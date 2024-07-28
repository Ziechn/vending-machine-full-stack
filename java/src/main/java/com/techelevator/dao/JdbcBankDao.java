package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Wallet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class JdbcBankDao implements BankDao{
    private final JdbcTemplate template;
    private WalletDao walletDao;

    public JdbcBankDao (JdbcTemplate template, WalletDao walletDao){
        this.template = template;
        this.walletDao = walletDao;
    }

    @Override
    public int getBankBalance() {
        int balance = 0;
        String sql = "SELECT * FROM bank;";

        try {
            SqlRowSet results = template.queryForRowSet(sql);
            if (results.next()){
                balance = results.getInt("balance");
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Bank DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Bank DAO] Error getting bank balance.");
        }

        return balance;
    }

    @Override
    public int updateBankBalance(int newBalance) {
        String sql = "UPDATE bank SET balance = ?;";

        try {
            template.update(sql, newBalance);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Bank DAO] Cannot access database.");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Bank DAO] Error updating bank balance.");
        }

        return getBankBalance();
    }


    @Override
    public int addFunds(int funds) {
        int newBalance = getBankBalance() + funds;
        return updateBankBalance(newBalance);
    }

    @Override
    public int withdrawalBankBalance(int userId) {
        int newUserBalance = walletDao.getWalletBalanceByUserId(userId) + getBankBalance();
        walletDao.updateWalletBalanceByUserId(userId, newUserBalance);
        return updateBankBalance(0);
    }
}
