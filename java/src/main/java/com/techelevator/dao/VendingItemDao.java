package com.techelevator.dao;

import com.techelevator.model.Purchase;
import com.techelevator.model.VendingItem;

import java.util.List;

public interface VendingItemDao {
    public List<VendingItem> getAllVendingItems();
    public VendingItem getVendingItemById(int id);
    public int purchaseVendingItem(Purchase purchase);
}
