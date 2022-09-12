package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    private Portfolio testPortfolio;

    @BeforeEach
    public void setup() {
        testPortfolio = new Portfolio(10000, 0.08, 0.01);

    }

    @Test
    public void testInvestZero() {
        double x = testPortfolio.getCapital();
        testPortfolio.invest(0);
        assertEquals(x, testPortfolio.getCapital());

    }

    @Test
    public void testInvestNonZero() {
        double x = testPortfolio.getCapital();
        testPortfolio.invest(1000);
        assertEquals(x + 1000, testPortfolio.getCapital());
    }

    @Test
    public void testAppreciateCapital() {
        double x = testPortfolio.getCapital() * (1 + testPortfolio.getEstimatedRoi());
        testPortfolio.appreciateCapital();
        assertEquals(x, testPortfolio.getCapital());
    }

    @Test
    public void testGetDividendPayment() {
        double x = testPortfolio.getDividendPaymentPercent() * testPortfolio.getCapital();
        assertEquals(x, testPortfolio.getDividendPayment());

    }

    @Test
    public void testSetters() {
        testPortfolio.setCapital(100000);
        assertEquals(100000, testPortfolio.getCapital());

        testPortfolio.setEstimatedRoi(0.05);
        assertEquals(0.05, testPortfolio.getEstimatedRoi());

        testPortfolio.setDividendPaymentPercent(0.10);
        assertEquals(0.10, testPortfolio.getDividendPaymentPercent());

    }

}
