package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.VendingItemDao;
import com.techelevator.dao.WalletDao;
import com.techelevator.model.Order;
import com.techelevator.model.Purchase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    private OrderDao orderDao;
    private VendingItemDao vendingItemDao;
    private WalletDao walletDao;
    private UserDao userDao;

    public OrderController(OrderDao orderDao, VendingItemDao vendingItemDao, WalletDao walletDao, UserDao userDao){
        this.orderDao = orderDao;
        this.vendingItemDao = vendingItemDao;
        this.walletDao = walletDao;
        this.userDao = userDao;
    }

    @PostMapping(path = "/order")
    public Order createOrder(@RequestBody Purchase purchase){
        // Get the current inventory of the vending item
        int vendingItemInventory = vendingItemDao.getVendingItemById(purchase.getVendingItemId()).getInventory();
        // Get the price of the item
        int vendingItemPrice = vendingItemDao.getVendingItemById(purchase.getVendingItemId()).getPrice();

        // Get the users wallet balance
        int userWalletBalance;

        if (purchase.getUserId() == 0){
            userWalletBalance = purchase.getWalletBalance();
        } else {
            userWalletBalance = walletDao.getWalletBalanceByUserId(purchase.getUserId());
        }

        if (vendingItemInventory <= 0){
            // If the inventory of the item is equal to or less than 0, thrown an exception.
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient inventory.");
        } else if (userWalletBalance < vendingItemPrice){
            // If the wallet balance is less than the price of the item, throw an exception.
            throw new ResponseStatusException(HttpStatus.PAYMENT_REQUIRED, "Insufficient wallet balance.");
        } else {
            // Otherwise, complete the purchase by subtracting the price from the wallet balance.
            purchase.setNewWalletBalance(walletDao.purchaseVendingItem(purchase));
            // And subtracting 1 from the vending item inventory.
            purchase.setNewInventory(vendingItemDao.purchaseVendingItem(purchase));

            return orderDao.purchaseOrder(purchase);
        }
    }

    @GetMapping(path = "/get-all-orders")
    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }

    @GetMapping(path = "/get-my-orders")
    public List<Order> getMyOrders(Principal principal){
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return orderDao.getOrdersByUserId(userId);
    }

    @GetMapping(path = "/get-order/{id}")
    public Order getOrderByOrderId(@PathVariable int id){
        return orderDao.getOrderByOrderId(id);
    }
}
