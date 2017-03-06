package com.eightbitsakathebigbyte;

import com.eightbitsbigbyte.CheckedAccount;
import com.eightbitsbigbyte.entity.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jeriahhumphrey on 3/2/17.
 */
public class CheckedAccountTest {
    CheckedAccount checked1;
    CheckedAccount checked2;
    CheckedAccount checked3;
    Account account1 = new Account("checking", 30000l, 0.0,3000l,0l,null, null);
    Account account2 = new Account("savings", 15000l, 0.01,3000l,10000l,null, null);
    Account account3 = new Account("money market", 2000000l, 0.05,3000l, 1000000l,null, null);

    @Before
    public void setUp(){
        checked1=new CheckedAccount(account1);
        checked2=new CheckedAccount(account2);
        checked3=new CheckedAccount(account3);
    }


    @Test
    public void isOverdraftTest(){
        account1.setBalance(-500l);
        assertTrue(checked1.isOverdraft());
    }
    @Test
    public void isOverdraftTest2(){
        assertFalse(checked1.isOverdraft());
    }

    @Test
    public void checkInterestRateNormalChecking(){
        assertEquals(0, checked1.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateNormalSavings(){
        assertEquals(0.01, checked2.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateNormalMoneyMarket(){
        assertEquals(0.05, checked3.checkInterestRate(), 0.0);

    }

    @Test
    public void checkInterestRateRMBSavings(){
        account2.setBalance(1000l);
        assertEquals(0.0, checked2.checkInterestRate(), 0.0);
    }

    @Test
    public void checkInterestRateRMBMoneyMarketTest(){
        account3.setBalance(1000l);
        assertEquals(-0.0, checked3.checkInterestRate(), 0.0);
    }



//    @Test
//    public void isRMBTest()  {
//        account2.setBalance(1000l);
//        assertTrue(checked2.isRMB());
//    }
//
//    @Test
//    public void isRMBTest2()  {
//        account3.setBalance(1000l);
//        assertTrue(checked3.isRMB());
//    }

    @Test
    public void setCheckedBalance() throws Exception {
        account1.setBalance(-1000l);
        assertEquals(-4000l,checked1.checkBalance());

    }

}