package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.WalletDao;
import com.techelevator.model.User;
import com.techelevator.model.Wallet;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class WalletController {
    private WalletDao walletDao;
    private UserDao userDao;

    public WalletController(WalletDao walletDao, UserDao userDao){
        this.walletDao = walletDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/get-wallet")
    public Wallet getWalletByUserId(Principal principal){
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return walletDao.getWalletByUserId(userId);
    }

    @GetMapping(path = "/get-wallet-balance")
    public int getWalletBalanceByUserId(Principal principal){
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return walletDao.getWalletBalanceByUserId(userId);
    }

    @PostMapping(path = "/update-wallet-balance")
    public int updateWalletBalanceByUserId(Principal principal, @RequestBody Wallet wallet){
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return walletDao.updateWalletBalanceByUserId(userId, wallet.getBalance());
    }
}
