package com.eightbitsbigbyte.dao;

import com.eightbitsbigbyte.entity.Account;

import java.util.Collection;

public interface AccountDao {
    Collection<Account> getAllAccounts();

    Account getAccountById(int id);

    void removeAccountById(int id);

    void updateAccount(Account account);

    void insertAccountToDb(Account account);
}
