package com.eightbitsbigbyte;

import com.eightbitsbigbyte.entity.Account;
import com.eightbitsbigbyte.entity.RecurringTransaction;

public class InterestCalculator {

    CheckedAccount checkedAccount;


    public long calculateComplexInterest(Account account, float interval, int frequency) {
        checkedAccount = new CheckedAccount(account);
        long interestAccrued = 10;
        long principal = account.getBalance();
        double interestRate = account.getInterestRate();
        long recurringTransaction = 0;
        if (account.getRecurringTransactions() != null) {
            for (int i = 0; i < account.getRecurringTransactions().size(); i++) {
                recurringTransaction += account.getRecurringTransactions().get(i).getAmount();
            }
        }
        interestAccrued = (long) ((principal * Math.pow(1 + (interestRate / frequency), (frequency * interval)) - principal)
                + recurringTransaction * (Math.pow((1 + (interestRate / frequency)), (frequency * interval)) - 1) / (interestRate / frequency));

        return interestAccrued;
    }

    private float month = 0.08333333333f;
    private float day = 0.002739726f;

    public long calculateSimpleInterest(Account account,float interval){
        if(hasDeduction(account) & consistentRecurringTransactions(account))
            account.setBalance(Long.valueOf(account.getBalance() + (account.getRecurringTransactions().get(0).getAmount()*12) * (long)interval));   // Assuming MONTHLY deductions.
        long interestOnPrincipal = simpleInterestEquation(account, interval);
        long interestOnRecurring = simpleRecurringEquation(account, filterRecurringTransactions(account), interval);
        return interestOnPrincipal + interestOnRecurring;
    }

    // SIMPLE INTEREST HELPER METHODS
    private long simpleInterestEquation(Account account, float interval) {
        if(crossesRMB(account, interval)) {
            long intOnInitialRate = (long)(account.getBalance()*account.getInterestRate()*(increasePastRMB(account,interval)*month));
            long intOnChangedRate = (long)(account.getBalance()*account.getInterestRate()*(interval/month - increasePastRMB(account,interval)*month));
            return intOnInitialRate + intOnChangedRate;
        }
        return (long)(account.getBalance()*account.getInterestRate()*interval);
    }

    private long simpleRecurringEquation(Account account, long transaction, float interval) {
        float maturity = interval/month;
        return (long)(transaction*(maturity*(maturity+1)/(2*12))*account.getInterestRate());
    }

    private long filterRecurringTransactions(Account account) {
        if(account.getRecurringTransactions().size()==0) return 0;
        if(hasDeduction(account)) return 0;
        return account.getRecurringTransactions().get(0).getAmount();
    }

    private boolean hasDeduction(Account account) {
        for(RecurringTransaction entry : account.getRecurringTransactions()) if(entry.getAmount()<0) return true;
        return false;
    }

    private boolean consistentRecurringTransactions(Account account) {
        for(int i=0;i<account.getRecurringTransactions().size()-1;i++)
            if(i<account.getRecurringTransactions().size()-1 && account.getRecurringTransactions().get(i).getAmount()!=account.getRecurringTransactions().get(i+1).getAmount())
                return false;
        return true;
    }

    private boolean belowRMB(Account account) {
        return account.getRequiredMB()>0 && account.getBalance()<=account.getRequiredMB();
    }

    private boolean crossesRMB(Account account, float interval) {
        return belowRMB(account) && filterRecurringTransactions(account)*interval/month + account.getBalance() >= account.getRequiredMB() |
                account.getBalance()>=account.getRequiredMB() && filterRecurringTransactions(account)*interval/month + account.getBalance() >= account.getRequiredMB();
    }

    private float increasePastRMB(Account account, float interval) {
        long tempBalance = account.getBalance();
        int deposits = 0;
        while(tempBalance<account.getRequiredMB()) {
            tempBalance += filterRecurringTransactions(account);
            deposits++;
        }
        return deposits;
    }

    private float decreasePastRMB(Account account, float interval) {
        long tempBalance = account.getBalance();
        int deductions = 0;
        while(tempBalance>account.getRequiredMB()) {
            tempBalance -= filterRecurringTransactions(account);
            deductions++;
        }
        return deductions;
    }

    // OTHER HELPER METHODS
    private boolean isOverdraft(Account account){
        return account.getBalance()<0;
    }
}

