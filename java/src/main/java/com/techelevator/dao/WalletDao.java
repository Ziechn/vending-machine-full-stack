package com.techelevator.dao;

import com.techelevator.model.Purchase;
import com.techelevator.model.Wallet;

public interface WalletDao {
    public Wallet createWallet(int userId);
    public Wallet getWalletByUserId(int id);
    public int getWalletBalanceByUserId(int id);
    public int updateWalletBalanceByUserId(int id, int newBalance);
    public int purchaseVendingItem(Purchase purchase);
}
