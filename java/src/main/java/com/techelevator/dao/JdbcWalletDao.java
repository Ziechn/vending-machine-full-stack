package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Wallet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class JdbcWalletDao implements WalletDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWalletDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Wallet getWalletByUserId(int id) {
        Wallet wallet = new Wallet();
        String sql = "SELECT * FROM wallet WHERE user_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()){
                wallet = mapResultsToWallet(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Cannot connect to the database");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Bad data.");
        }

        return wallet;
    }

    @Override
    public int getWalletBalanceByUserId(int id) {

        int balance = 0;
        String sql = "SELECT balance FROM wallet WHERE user_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()){
                balance = results.getInt("balance");
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Cannot connect to the database");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Bad data.");
        }

        return balance;
    }

    @Override
    public int updateWalletBalanceByUserId(int id, int newBalance) {
        int balance = 0;
        String sql = "UPDATE wallet SET balance = ? WHERE user_id = ? RETURNING balance;";
        try{
            balance = jdbcTemplate.update(sql, int.class, newBalance, id);
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Cannot connect to the database");
        } catch (DataIntegrityViolationException e){
            throw new DaoException(LocalDateTime.now() + " [JDBC Wallet DAO] Bad data.");
        }
        return balance;
    }


    private Wallet mapResultsToWallet(SqlRowSet results){
        return new Wallet(
                results.getInt("id"),
                results.getInt("user_id"),
                results.getInt("balance")
        );
    }
}
