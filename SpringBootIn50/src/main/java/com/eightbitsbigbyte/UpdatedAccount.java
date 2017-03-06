package com.eightbitsbigbyte;

/**
 * Created by gillianreynolds-titko on 3/5/17.
 */
public class UpdatedAccount {
    CheckedAccount checkedAccount;
    long updatedPrincipal = 0L;
    long interestEarned = 0L;

    InterestCalculator interestCalculator;

    public long calculateNewAccountBalance(CheckedAccount checkedAccount, String typeOfInterestCalculation, float interval, int frequency){
        if(typeOfInterestCalculation.equals("complex")){
            interestEarned = interestCalculator.calculateComplexInterest(checkedAccount.newAccount, interval, frequency);
            updatedPrincipal = checkedAccount.checkBalance() + interestEarned;
            return updatedPrincipal;
        } else
            interestEarned = interestCalculator.calculateSimpleInterest(checkedAccount.newAccount, interval);
            updatedPrincipal = checkedAccount.checkBalance() + interestEarned;
            return updatedPrincipal;
    }
}
