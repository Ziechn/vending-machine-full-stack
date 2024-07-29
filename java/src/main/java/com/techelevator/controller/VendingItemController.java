package com.techelevator.controller;

import com.techelevator.dao.VendingItemDao;
import com.techelevator.model.VendingItem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
public class VendingItemController {
    private VendingItemDao vendingItemDao;

    public VendingItemController(VendingItemDao vendingItemDao){
        this.vendingItemDao = vendingItemDao;
    }

    @GetMapping(path = "/all-vending-items")
    public List<VendingItem> getAllVendingItems(){
        System.out.println(LocalDateTime.now() + " A list of all vending items have been retrieved.");
        return vendingItemDao.getAllVendingItems();
    }

    @GetMapping(path = "/vending-item/{id}")
    public VendingItem getVendingItemById(@PathVariable int id){
        System.out.println(LocalDateTime.now() + " Information for vending item ID: " + id + " has been retrieved.");
        return vendingItemDao.getVendingItemById(id);
    }
}
