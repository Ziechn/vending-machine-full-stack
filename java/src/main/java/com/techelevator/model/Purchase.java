package com.techelevator.model;

import java.util.Date;

public class Purchase {

    // Expected data...
    private int vendingItemId;
    private int userId;
    private int walletBalance;
    private int purchasePrice;
    private Date date;

    // Pass through data...
    private int newWalletBalance;
    private int newInventory;

    public int getVendingItemId() {
        return vendingItemId;
    }

    public void setVendingItemId(int vendingItemId) {
        this.vendingItemId = vendingItemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance) {
        this.walletBalance = walletBalance;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getNewWalletBalance() {
        return newWalletBalance;
    }

    public void setNewWalletBalance(int newWalletBalance) {
        this.newWalletBalance = newWalletBalance;
    }

    public int getNewInventory() {
        return newInventory;
    }

    public void setNewInventory(int newInventory) {
        this.newInventory = newInventory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
