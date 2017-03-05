package com.eightbitsbigbyte.entity;

public class Account {

    private int id;
    private String accountType;
    private long balance;
    private double interestRate;
    private long overdraftPenalty;
    private long requiredMB;

    public Account(int id, String accountType, long balance, double interestRate, long overdraftPenalty, long requiredMB) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.overdraftPenalty = overdraftPenalty;
        this.requiredMB = requiredMB;
    }

    public Account(){}

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



}
