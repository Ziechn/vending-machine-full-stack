package com.techelevator.dao;

public interface BankDao {
    public int getBankBalance();
    public int updateBankBalance(int newBalance);
    public int addFunds(int funds);
    public int withdrawalBankBalance(int userId);
}
