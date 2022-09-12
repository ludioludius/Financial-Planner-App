package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    private SavingsAccount testSavingsAccount;

    @BeforeEach
    public void setup(){
        testSavingsAccount = new SavingsAccount(10000, 0.02);
    }

    @Test
    public void testWithdrawZero(){
        double x = testSavingsAccount.getBalance();
        testSavingsAccount.withdraw(0);
        assertEquals(x, testSavingsAccount.getBalance());
    }

    @Test
    public void testWithdrawNonZeroMultipleTimes(){
        double x = testSavingsAccount.getBalance() - 100 - 100;
        testSavingsAccount.withdraw(100);
        testSavingsAccount.withdraw(100);
        assertEquals(x, testSavingsAccount.getBalance());
    }

    @Test
    public void testDepositZero(){
        double x = testSavingsAccount.getBalance();
        testSavingsAccount.deposit(0);
        assertEquals(x, testSavingsAccount.getBalance());
    }

    @Test
    public void testDepositMultiple(){
        double x = testSavingsAccount.getBalance() + 100 + 100;
        testSavingsAccount.deposit(100);
        testSavingsAccount.deposit(100);
        assertEquals(x, testSavingsAccount.getBalance());
    }

    @Test
    public void testApplyInterestRateMultipleTimes(){
        double x = testSavingsAccount.getBalance() * (1 + 0.02) *(1 + 0.02);
        testSavingsAccount.applyInterestRate();
        testSavingsAccount.applyInterestRate();
        assertEquals(x, testSavingsAccount.getBalance());

    }

    @Test
    public void testSetBalance() {
        testSavingsAccount.setBalance(10000);
        assertEquals(10000, testSavingsAccount.getBalance());
    }

    @Test
    public void testSetInterestRate() {
        testSavingsAccount.setInterestRate(10);
        assertEquals(10, testSavingsAccount.getInterestRate());
    }

}
