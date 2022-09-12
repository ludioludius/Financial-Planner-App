package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    private Loan testLoan;
    private Loan closedLoan;

    @BeforeEach
    public void setup() {
        testLoan = new Loan("Car Loan", 20000, 36, 0.03);
        closedLoan = new Loan("Mortgage", 0.0, 0, 0.01);
    }


    @Test
    public void testConstructor() {
        assertEquals("Car Loan", testLoan.getLoan());
        assertEquals(20000, testLoan.getOutstandingBalance());
        assertEquals(36, testLoan.getMonthsToPayLoan());
        assertEquals(0.03, testLoan.getInterestRate());
        assertTrue(testLoan.getStatus());
    }

    @Test
    public void testMakeMonthlyPayment() {
        double initialOutstandingBalance = testLoan.getOutstandingBalance();
        double monthlyPaymentToPrinciple = testLoan.getOutstandingBalance() / testLoan.getMonthsToPayLoan();
        int monthsToPayLoan = testLoan.getMonthsToPayLoan();
        testLoan.makeMonthlyPayment();
        assertEquals(testLoan.getOutstandingBalance(), initialOutstandingBalance - monthlyPaymentToPrinciple);
        assertEquals(testLoan.getMonthsToPayLoan(), monthsToPayLoan - 1);
    }

    @Test
    public void testMakeMonthlyPaymentOnClosedLoan() {
        closedLoan.setStatus(false);
        double outbalance = closedLoan.getOutstandingBalance();
        closedLoan.makeMonthlyPayment();
        assertFalse(closedLoan.getStatus());
        assertEquals(closedLoan.getOutstandingBalance(), outbalance); // no changes to outstanding balance

    }

    @Test
    public void testMakeMultipleMonthlyPayments() {
        double initialOutstandingBalance = testLoan.getOutstandingBalance();
        double monthlyPaymentToPrinciple = testLoan.getOutstandingBalance() / testLoan.getMonthsToPayLoan();
        int monthsToPayLoan = testLoan.getMonthsToPayLoan();
        testLoan.makeMonthlyPayment();
        assertEquals(testLoan.getOutstandingBalance(), initialOutstandingBalance - monthlyPaymentToPrinciple);
        assertEquals(testLoan.getMonthsToPayLoan(), monthsToPayLoan - 1);

        initialOutstandingBalance = testLoan.getOutstandingBalance();
        monthlyPaymentToPrinciple = testLoan.getOutstandingBalance() / testLoan.getMonthsToPayLoan();
        monthsToPayLoan = testLoan.getMonthsToPayLoan();
        testLoan.makeMonthlyPayment();
        assertEquals(testLoan.getOutstandingBalance(), initialOutstandingBalance - monthlyPaymentToPrinciple);
        assertEquals(testLoan.getMonthsToPayLoan(), monthsToPayLoan - 1);

    }

    @Test
    public void testMultiplePaymentsLoanCloses() {


        for (int i = 1; i <= 36; i++) {
            testLoan.makeMonthlyPayment();
        }

        assertFalse(testLoan.getStatus());
        assertEquals(testLoan.getOutstandingBalance(), 0.0);
    }

    @Test
    public void testSetters() {
        testLoan.setLoan("student loan");
        testLoan.setOutstandingBalance(50000);
        testLoan.setInterestRate(0.05);
        testLoan.setMonthsToPayLoan(56);

        assertEquals("student loan", testLoan.getLoan());
        assertEquals(50000, testLoan.getOutstandingBalance());
        assertEquals(0.05, testLoan.getInterestRate());
        assertEquals(56, testLoan.getMonthsToPayLoan());
    }

    @Test
    public void testMonthlyPaymentClosedLoan() {
        testLoan.setStatus(false);

        assertEquals(testLoan.monthlyPayment(), 0.0);
    }
}


