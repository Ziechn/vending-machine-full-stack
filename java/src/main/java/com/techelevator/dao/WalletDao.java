package com.techelevator.dao;

import com.techelevator.model.Wallet;

public interface WalletDao {
    public Wallet getWalletByUserId(int id);
    public Wallet updateWalletByUserId(int id);
}
