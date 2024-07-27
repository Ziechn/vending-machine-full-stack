package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private int vendingItemId;
    private int total;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVendingItemId() {
        return vendingItemId;
    }

    public void setVendingItemId(int vendingItemId) {
        this.vendingItemId = vendingItemId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
