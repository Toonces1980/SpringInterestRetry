package com.eightbitsbigbyte.dao;

import com.eightbitsbigbyte.entity.Account;

import java.util.Collection;

public interface AccountDao {
    Collection<Account> getAllAccounts();

    Account getAccountById(int id);

    Account getAccountByIdAndName(int id, String firstName, String lastName);

    void removeAccountById(int id);

    void removeAccountByIdAndName(int id, String firstName, String lastName);

//    void updateAccount(Account account);

    void insertAccountToDb(Account account);
}
