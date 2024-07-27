package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao {

    private final JdbcTemplate template;

    public JdbcOrderDao(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public Order createOrder(Order order) {
        String sql = "INSERT INTO orders (user_id, vending_item_id, total, date) VALUES (?, ?, ?, ?) RETURNING id;";
        int orderId;

        try {
            orderId = template.queryForObject(
                    sql,
                    int.class,
                    order.getUserId(),
                    order.getVendingItemId(),
                    order.getTotal(),
                    order.getDate()
            );
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot create order.");
        } catch (NullPointerException e) {
            throw new NullPointerException(LocalDateTime.now() + " [JDBC Order DAO] Null order ID.");
        }

        return getOrderByOrderId(orderId);
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        Order order = new Order();
        String sql = "SELECT * FROM orders WHERE id = ?;";

        try {
            SqlRowSet results = template.queryForRowSet(sql, orderId);
            if (results.next()){
                order = mapRowToOrder(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot get order by ID: " + orderId);
        }

        return order;
    }


    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY date ASC;";

        try {
            SqlRowSet results = template.queryForRowSet(sql);
            while (results.next()){
                orders.add(mapRowToOrder(results));
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot get all orders.");
        }

        return orders;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY date ASC;";

        try {
            SqlRowSet results = template.queryForRowSet(sql, userId);
            while (results.next()){
                orders.add(mapRowToOrder(results));
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Order DAO] Cannot get all orders for user ID: " + userId);
        }

        return orders;
    }

    private Order mapRowToOrder(SqlRowSet results){
        Order order = new Order();
        order.setId(results.getInt("id"));
        order.setUserId(results.getInt("user_id"));
        order.setVendingItemId(results.getInt("vending_item_id"));
        order.setTotal(results.getInt("total"));
        order.setDate(results.getDate("date"));
        return order;
    }
}
