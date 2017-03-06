package com.eightbitsbigbyte.entity;

import java.util.ArrayList;

public class Account {
    private int id;
    private String accountType;
    private long balance;
    private double interestRate;
    private long overdraftPenalty;
    private long requiredMB;
    private String firstName;
    private String lastName;
    private ArrayList<RecurringTransaction> recurringTransactions;

    public Account(String accountType, long balance, double interestRate, long overdraftPenalty, long requiredMB, String firstName, String lastName) {
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.overdraftPenalty = overdraftPenalty;
        this.requiredMB = requiredMB;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public long getOverdraftPenalty() {
        return overdraftPenalty;
    }

    public void setOverdraftPenalty(long overdraftPenalty) {
        this.overdraftPenalty = overdraftPenalty;
    }

    public long getRequiredMB() {
        return requiredMB;
    }

    public void setRequiredMB(long requiredMB) {
        this.requiredMB = requiredMB;
    }

    public ArrayList<RecurringTransaction> getRecurringTransactions() {
        return recurringTransactions;
    }

    public void setRecurringTransactions(ArrayList<RecurringTransaction> recurringTransactions) {
        this.recurringTransactions = recurringTransactions;
    }





}
