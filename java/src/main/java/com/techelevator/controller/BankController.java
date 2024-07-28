package com.techelevator.controller;

import com.techelevator.dao.BankDao;
import com.techelevator.dao.UserDao;
import com.techelevator.dao.WalletDao;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class BankController {
    private BankDao bankDao;
    private UserDao userDao;

    public BankController(BankDao bankDao, UserDao userDao){
        this.bankDao = bankDao;
        this.userDao = userDao;
    }

    @GetMapping(path = "/get-bank-balance")
    public int getBankBalance(){
        return bankDao.getBankBalance();
    }

    @PostMapping(path = "/withdrawal-bank-balance")
    public int withdrawalBankBalance(Principal principal){
        int userId = userDao.getUserByUsername(principal.getName()).getId();
        return bankDao.withdrawalBankBalance(userId);
    }
}
