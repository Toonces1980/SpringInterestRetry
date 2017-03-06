package com.eightbitsbigbyte;

import com.eightbitsbigbyte.entity.Account;

public class CheckedAccount {
    Account newAccount;
    double storedInterestRate;

    public CheckedAccount(Account account){
        newAccount=account;
        //checkInterestRate();
        checkBalance();
        storedInterestRate = account.getInterestRate();
    }

    private boolean isChecking(){
        if (newAccount.getAccountType().toLowerCase().equals("checking")){
            return true;
        }
        return false;
    }

    private boolean isSavings(){
        if (newAccount.getAccountType().toLowerCase().equals("savings")){
            return true;
        }
        return false;
    }

    private boolean isMoneyMarket(){
        if (newAccount.getAccountType().toLowerCase().equals("money market")){
            return true;
        }
        return false;
    }

    public boolean isOverdraft(){
    if (newAccount.getBalance()<0){
        return true;
        }
        return false;
    }

    private void checkRMBInterestRate(){
        if(newAccount.getBalance()<newAccount.getRequiredMB()){
            newAccount.setInterestRate(0.0);
        }
        else{
            newAccount.setInterestRate(storedInterestRate);
        }

    }

    public double checkInterestRate(){
        checkRMBInterestRate();
        return newAccount.getInterestRate();
    }


    public long checkMinimumBalanceRequirement(){
        if(isChecking()){
            newAccount.setRequiredMB(0L);
        }
        if(isSavings()){
            newAccount.setRequiredMB(10000L);
        }
        if(isMoneyMarket()){
            newAccount.setRequiredMB(1000000L);
        }
        return newAccount.getRequiredMB();
    }

    public void resetInterestRate(){
        if(newAccount.getBalance() < newAccount.getRequiredMB() && newAccount.getAccountType().equals("savings")){
            newAccount.setInterestRate(0.0);
        } else if(newAccount.getBalance() < newAccount.getRequiredMB() && newAccount.getAccountType().equals("money market")){
            newAccount.setInterestRate(0.0);
        }
    }


    public void setCheckedBalance() {
        if (isOverdraft()) {
            newAccount.setBalance(newAccount.getBalance() - newAccount.getOverdraftPenalty());
        }
    }

    public long checkBalance(){
                setCheckedBalance();
                return newAccount.getBalance();
    }
    }




