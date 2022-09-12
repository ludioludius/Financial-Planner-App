package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryTest {
    private Salary testSalary;

    @BeforeEach
    public void setup() {
        testSalary = new Salary(100000, 0.50, 0.02,
                0.13);

    }

    @Test
    public void testCalculateNetIncome() {
        double x = testSalary.getGrossSalary() * (1 - testSalary.getEstimatedTaxPercent());
        assertEquals(x, testSalary.calculateNetIncome());
    }

    @Test
    public void testIncomeInvestedAnnually() {
        double x = testSalary.calculateNetIncome() * testSalary.getPercentNetSalaryInvested();
        assertEquals(x, testSalary.incomeInvestedAnnually());
    }

    @Test
    public void testIncomeSavedAnnually() {
        double x = testSalary.calculateNetIncome() - testSalary.incomeInvestedAnnually();
        assertEquals(x, testSalary.incomeSavedAnnually());
    }

    @Test
    public void testIncreaseSalary() {
        double x = testSalary.getGrossSalary() * (1 + testSalary.getAverageAnnualSalaryGrowthRate());
        testSalary.increaseSalary();
        assertEquals(x, testSalary.getGrossSalary());
    }

    @Test
    public void testSetters() {
        testSalary.setGrossSalary(10000);
        assertEquals(10000, testSalary.getGrossSalary());

        testSalary.setPercentNetSalaryInvested(0.50);
        assertEquals(0.50, testSalary.getPercentNetSalaryInvested());

        testSalary.setEstimatedTaxPercent(0.40);
        assertEquals(0.40, testSalary.getEstimatedTaxPercent());

        testSalary.setAverageAnnualSalaryGrowthRate(0.05);
        assertEquals(0.05, testSalary.getAverageAnnualSalaryGrowthRate());

    }
}
