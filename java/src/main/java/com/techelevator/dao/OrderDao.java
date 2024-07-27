package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {
    public Order createOrder(Order order);
    public Order getOrderByOrderId(int orderId);
    public List<Order> getAllOrders();
    public List<Order> getOrdersByUserId(int userId);
}
