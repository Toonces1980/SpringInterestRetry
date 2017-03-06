package com.eightbitsakathebigbyte;
import com.eightbitsbigbyte.InterestCalculator;
import com.eightbitsbigbyte.entity.Account;
import com.eightbitsbigbyte.entity.RecurringTransaction;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InterestCalculatorTest {

    InterestCalculator interestCalculator;
    Account savingsAccount;
    Account moneyMarketAccount;

    @Before
    public void setUp(){
        interestCalculator = new InterestCalculator();
        savingsAccount = new Account("Savings", 40000L, 0.1f, 3500L, 10000L, null, null);
        moneyMarketAccount = new Account("Savings", 1000000L, 0.1f, 7500L, 500000L, null, null);
        //String accountType, Long balance, Double interestRate, Long overdraftPenalty, Long requiredMinimumBalance, ArrayList<RecurringTransaction> recurringTransactions
    }

    @After
    public void tearDown() {
        savingsAccount.setBalance(Long.valueOf(40000));
        savingsAccount.setInterestRate(Double.valueOf(0.1));
        savingsAccount.setRequiredMB(Long.valueOf(10000));
        if(savingsAccount.getRecurringTransactions().size()>0)savingsAccount.getRecurringTransactions().remove(0);
        moneyMarketAccount.setBalance(Long.valueOf(1000000));
        moneyMarketAccount.setInterestRate(Double.valueOf(0.1));
        if(moneyMarketAccount.getRecurringTransactions().size()>0)moneyMarketAccount.getRecurringTransactions().remove(0);
    }

    //P=$100;  r=0.1; n1 = 1 (annual); n2 = 4 (quarterly); t=1 (in yrs == 365 days)
    //Interval used in SimpleInterest and CompoundInterest will be a float
    //Equation for interest: i=P(1+(r/n))^(n*t)-P
    //Results need to be in pennies.

//    @Test
//    public void compIntNonZeroNoRmbTest(){
//        long intExpected;
//        long intActual;
//    }
//
//    @Test
//    public void simpleInterestNormalBalanceNoRMBTest() {
//        savingsAccount.setRequiredMB(Long.valueOf(0));
//        long expected = 4000;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount,1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestAboveRMBTest() {
//        long expected = 4000;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestBelowRMBNonzeroTest() {
//        savingsAccount.setBalance(Long.valueOf(5000));
//        savingsAccount.setInterestRate(Double.valueOf(0.05));
//        long expected = 250;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestZeroBalanceTest() {
//        savingsAccount.setBalance(Long.valueOf(0));
//        savingsAccount.setInterestRate(Double.valueOf(0.05));
//        long expected = 0;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestZeroBalanceBelowRMBTest() {
//        savingsAccount.setBalance(Long.valueOf(0));
//        savingsAccount.setInterestRate(Double.valueOf(0.05));
//        savingsAccount.setRequiredMB(Long.valueOf(0));
//        long expected = 0;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestNegBalanceNoRMBTest() {
//        savingsAccount.setBalance(Long.valueOf(-10000));
//        savingsAccount.setInterestRate(Double.valueOf(0));
//        long expected = 0;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestNegBalanceBelowRMBTest() {
//        savingsAccount.setBalance(Long.valueOf(-10000));
//        savingsAccount.setInterestRate(Double.valueOf(0));
//        savingsAccount.setRequiredMB(Long.valueOf(0));
//        long expected = 0;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestRecurDeductionsNotExceedInterestTest() {
//        savingsAccount.getRecurringTransactions().add(0, new RecurringTransaction(1,-200));
//        long expected = 3760;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestRecurDeductionsExceedInterestTest() {
//        savingsAccount.getRecurringTransactions().add(0, new RecurringTransaction(1,-500));
//        long expected = 3400;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestRecurContributionBelowRMBTest() {
//        savingsAccount.setBalance(Long.valueOf(4000));
//        savingsAccount.setInterestRate(Double.valueOf(0.05));
//        savingsAccount.getRecurringTransactions().add(0, new RecurringTransaction(1,500));
//        long expected = 362;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
//
//    @Test
//    public void simpleInterestBlowRMBRecurringContributionAboveRMBTest() {
//        savingsAccount.setBalance(Long.valueOf(5000));
//        savingsAccount.setInterestRate(Double.valueOf(0.05));
//        savingsAccount.getRecurringTransactions().add(0, new RecurringTransaction(1,500));
//        long expected = 500;
//        long actual = interestCalculator.calculateSimpleInterest(savingsAccount, 1);
//        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
//    }
/*
    @Test
    public void simpleInterestBlowRMBRecurringContributionAboveRMBTest() {
        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }
    @Test
    public void simpleInterestLowBalGetOverDrawnNotAboveZeroTest() {
        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }
    @Test
    public void simpleInterestLowBalGetOverDrawnAboveZeroTest() {
        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }
    @Test
    public void simpleInterestLowBalOverdrawnNotAboveZeroTest() {
        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
    }
    @Test
    public void simpleInterestLowBalOverdrawnAboveZeroTest() {
        long expected;
        long actual = interestCalculator.calculateSimpleInterest(account, 30);
        assertEquals("Return the amount of interest that is accrued over the passed in time interval",expected,actual);
*/
}