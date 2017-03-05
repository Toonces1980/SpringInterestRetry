package com.eightbitsbigbyte.service;

import com.eightbitsbigbyte.dao.AccountDao;
import com.eightbitsbigbyte.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AccountService {

    @Autowired
    @Qualifier("mysql")
    private AccountDao accountDao;

    public Collection<Account> getAllAccounts(){
        return this.accountDao.getAllAccounts();
    }

    public Account getAccountById(int id){
        return this.accountDao.getAccountById(id);
    }


    public void removeAccountById(int id) {
        this.accountDao.removeAccountById(id);
    }

    public void updateAccount(Account account){
        this.accountDao.updateAccount(account);
    }

    public void insertAccount(Account account) {
        this.accountDao.insertAccountToDb(account);
    }
}
