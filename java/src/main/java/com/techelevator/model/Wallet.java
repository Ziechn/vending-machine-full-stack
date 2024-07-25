package com.techelevator.model;

public class Wallet {
    private int id;
    private int balance;

    public Wallet(){
        id = -1;
        balance = 0;
    }

    public Wallet(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
