package com.eightbitsbigbyte.dao;

import com.eightbitsbigbyte.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("mysql")
public class MySqlAccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setAccountType(resultSet.getString("accountType"));
            account.setBalance(resultSet.getLong("balance"));
            account.setInterestRate(resultSet.getDouble("interestRate"));
            account.setOverdraftPenalty(resultSet.getLong("overdraftPenalty"));
            account.setRequiredMB(resultSet.getLong("requiredMB"));
            account.setFirstName(resultSet.getString("firstName"));
            account.setLastName(resultSet.getString("lastName"));
            return account;
        }
    }


    @Override
    public Collection<Account> getAllAccounts() {
        // SELECT column_name(s) FROM table_name
        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account";
        List<Account> accounts = jdbcTemplate.query(sql, new StudentRowMapper());
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account where id = ?";
        Account account = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return account;
    }

    @Override
    public Account getAccountByIdAndName(int id, String firstName, String lastName) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName FROM account where id = ?, firstName = ?, lastName = ?";
        Account account = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return account;
    }

    @Override
    public void removeAccountById(int id) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        final String sql = "DELETE FROM account WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void removeAccountByIdAndName(int id, String firstName, String lastName) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        final String sql = "DELETE FROM account WHERE id = ?, firstName = ?, lastName = ?";
        jdbcTemplate.update(sql, id);
    }

//    @Override
//    public void updateAccount(Account account) {
//        // UPDATE table_name
//        // SET column1=value, column2=value2,...
//        // WHERE some_column=some_value
//        final String sql = "UPDATE account SET name = ?, course = ? WHERE id = ?";
//        final int id = account.getId();
//        final String accountType = account.getAccountType();
//        final long balance = account.getBalance();
//        final double interestRate = account.getInterestRate();
//        final long overdraftPenalty = account.getOverdraftPenalty();
//        final long requiredMB = account.getRequiredMB();
//        jdbcTemplate.update(sql, new Object[]{accountType, balance, interestRate, overdraftPenalty, requiredMB, id});
//    }

    @Override
    public void insertAccountToDb(Account account) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO account (accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName) VALUES (?, ?, ?, ?, ?, ?, ?)";
        final String accountType = account.getAccountType();
        final long balance = account.getBalance();
        final double interestRate = account.getInterestRate();
        final long overdraftPenalty = account.getOverdraftPenalty();
        final long requiredMB = account.getRequiredMB();
        final String firstName = account.getFirstName();
        final String lastName = account.getLastName();
        jdbcTemplate.update(sql, new Object[]{accountType, balance, interestRate, overdraftPenalty, requiredMB, firstName, lastName});

    }
}