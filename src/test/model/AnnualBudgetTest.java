package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnnualBudgetTest {

    private AnnualBudget testBudget;

    private Expense gas;
    private Expense gymMembership;
    private Expense internet;
    private Expense groceries;

    private Loan carLoan;
    private Loan mortgage;


    @BeforeEach
    public void setup() {

        gas = new Expense("gas", 50);
        gymMembership = new Expense("Gym Membership", 2000);
        internet = new Expense("internet", 70);
        groceries = new Expense("groceries", 100);
        ArrayList<Expense> expenses = new ArrayList<>(0);
        expenses.add(gas);
        expenses.add(gymMembership);
        expenses.add(internet);
        expenses.add(groceries);

        carLoan = new Loan("Car Loan", 30000, 36, 0.03);
        mortgage = new Loan("Mortgage", 100000, 540, 0.02);
        ArrayList<Loan> loans = new ArrayList<>(0);
        loans.add(carLoan);
        loans.add(mortgage);

        testBudget = new AnnualBudget(expenses, loans);
    }

    @Test
    public void testTotalAnnualBudget() {

        assertEquals(39206.66666666667, testBudget.totalAnnualBudget()); //verified by hand

    }

    @Test
    public void testSetters() {
        ArrayList<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense("random", 40));

        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(new Loan("student loan", 2000, 24, 0.01));

        testBudget.setExpenses(expenses);
        assertEquals(expenses, testBudget.getExpenses());
        testBudget.setLoans(loans);
        assertEquals(loans,testBudget.getLoans());

    }




}
