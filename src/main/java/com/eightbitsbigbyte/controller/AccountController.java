package com.eightbitsbigbyte.controller;

import com.eightbitsbigbyte.entity.Account;
import com.eightbitsbigbyte.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Account getAccountById(@PathVariable("id") int id){
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccountById(@PathVariable("id") int id){
        accountService.removeAccountById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAccountById(@RequestBody Account account){
        accountService.updateAccount(account);
    }

    @RequestMapping(value  = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertAccount(@RequestBody Account account){
        accountService.insertAccount(account);
    }
}
