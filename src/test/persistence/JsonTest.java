package persistence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    //Effects: checks if all fields of both loans are equal
    protected void checkLoan(Loan loan1, Loan loan2) {
        assertEquals(loan1.getLoan(), loan2.getLoan());
        assertEquals(loan1.getOutstandingBalance(), loan2.getOutstandingBalance());
        assertEquals(loan1.getMonthsToPayLoan(), loan2.getMonthsToPayLoan());
        assertEquals(loan1.getInterestRate(), loan2.getInterestRate());
    }

    //Effects: checks if all fields of both expenses are equal
    protected void checkExpenses(Expense e1, Expense e2) {
        assertEquals(e1.getCost(), e2.getCost());
        assertEquals(e1.getExpense(), e2.getExpense());
    }

    //Effects: checks if all fields of both portfolios are equal
    protected void checkPortfolio(Portfolio portfolio1, Portfolio portfolio2) {
        assertEquals(portfolio1.getCapital(), portfolio2.getCapital());
        assertEquals(portfolio1.getEstimatedRoi(), portfolio2.getEstimatedRoi());
        assertEquals(portfolio1.getDividendPaymentPercent(), portfolio2.getDividendPaymentPercent());
    }
    //Effects: checks if all fields of both properties are equal
    protected void checkRealEstate(RealEstate property1, RealEstate property2) {
        assertEquals(property1.getEstimatedAppreciation(), property2.getEstimatedAppreciation());
        assertEquals(property1.getPropertyCosts(), property2.getPropertyCosts());
        assertEquals(property1.getRentalIncome(), property2.getRentalIncome());
        assertEquals(property1.getValuation(), property1.getValuation());
    }
    //Effects: checks if all fields of both salaries are equal
    protected void checkSalary (Salary s1, Salary s2) {
        assertEquals(s1.getGrossSalary(),s1.getGrossSalary());
        assertEquals(s1.getPercentNetSalaryInvested(), s2.getPercentNetSalaryInvested());
        assertEquals(s1.getAverageAnnualSalaryGrowthRate(), s2.getAverageAnnualSalaryGrowthRate());
        assertEquals(s1.getEstimatedTaxPercent(), s2.getEstimatedTaxPercent());

    }
    //Effects: checks if all fields of both accounts are equal
    protected void checkSavingsAccount(SavingsAccount s1, SavingsAccount s2) {
        assertEquals(s1.getBalance(), s2.getBalance());
        assertEquals(s1.getInterestRate(), s2.getInterestRate());
    }
}
