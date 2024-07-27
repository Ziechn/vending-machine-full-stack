package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {
    public Order createOrder(Order order);
    public List<Order> getAllOrders();
}
