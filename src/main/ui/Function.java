package ui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class Function implements ActionListener {
    protected JTextField years;
    protected GUI gui;
    protected Finance copyFinance;
    protected JTextField inflation;

    public Function(JTextField years, GUI gui) {
        this.gui = gui;
        this.years = years;
    }


    protected abstract void updateGUI();

    //Effects: simulates the state of finances after 1 year
    protected void simulateOneYear(SavingsAccount sav, Salary s, Portfolio p, RealEstate r,
                                 AnnualBudget b, Double dividendSaved, Double rentSaved) {
        double inc = s.calculateNetIncome() - b.totalAnnualBudget();

        sav.deposit(inc * (1 - (s.getPercentNetSalaryInvested()))); //make get percent salary saved method?
        p.invest(inc * (s.getPercentNetSalaryInvested()));

        sav.deposit((p.getDividendPayment()) * (dividendSaved));
        p.invest(p.getDividendPayment() * (1 - (dividendSaved)));

        sav.deposit(r.netAnnualRentalIncome() * (rentSaved));
        p.invest(r.netAnnualRentalIncome() * (1 - (rentSaved)));

        p.appreciateCapital();
        sav.applyInterestRate();
        s.increaseSalary();
    }

    //Modifies: this
    // Creates a copy of Gui.Finance to manipulate
    protected void createCopyFinance() {
        copyFinance = new Finance("copy");
        copyFinance.setExpenses(createCopyExpenses(gui.getFinance().getExpenses())); // get expenses from gui
        copyFinance.setLoans(createCopyLoans(gui.getFinance().getLoans())); // get loans from gui
        copyFinance.setAnnualBudget(new AnnualBudget(copyFinance.getExpenses(), copyFinance.getLoans()));

        copyFinance.getSalary().setPercentNetSalaryInvested(gui.getFinance().getSalary().getPercentNetSalaryInvested());
        copyFinance.getSalary().setAverageAnnualSalaryGrowthRate(gui.getFinance().getSalary()
                .getAverageAnnualSalaryGrowthRate());
        copyFinance.getSalary().setEstimatedTaxPercent(gui.getFinance().getSalary().getEstimatedTaxPercent());
        copyFinance.getSalary().setGrossSalary(gui.getFinance().getSalary().getGrossSalary());

        copyFinance.getProperty().setValuation(gui.getFinance().getProperty().getValuation());
        copyFinance.getProperty().setEstimatedAppreciation(gui.getFinance().getProperty().getEstimatedAppreciation());
        copyFinance.getProperty().setRentalIncome(gui.getFinance().getProperty().getRentalIncome());
        copyFinance.getProperty().setPropertyCosts(gui.getFinance().getProperty().getPropertyCosts());

        copyFinance.getPortfolio().setDividendPaymentPercent(gui.getFinance().getPortfolio()
                .getDividendPaymentPercent());
        copyFinance.getPortfolio().setEstimatedRoi(gui.getFinance().getPortfolio().getEstimatedRoi());
        copyFinance.getPortfolio().setCapital(gui.getFinance().getPortfolio().getCapital());

        copyFinance.getSalary().setGrossSalary(gui.getFinance().getSalary().getGrossSalary());
        copyFinance.getSalary().setEstimatedTaxPercent(gui.getFinance().getSalary().getEstimatedTaxPercent());
        copyFinance.getSalary().setAverageAnnualSalaryGrowthRate(gui.getFinance().getSalary()
                .getAverageAnnualSalaryGrowthRate());
        copyFinance.getSalary().setPercentNetSalaryInvested(gui.getFinance().getSalary().getPercentNetSalaryInvested());
    }


    //Effects: creates a copy of expenses that can be changed independently without affecting original
    protected ArrayList<Expense> createCopyExpenses(ArrayList<Expense> expenses) {
        ArrayList<Expense> copyExpenses = new ArrayList<>();
        for (Expense e : expenses) {
            String expense = e.getExpense();
            Double cost = e.getCost();
            Expense copyExpense = new Expense(expense, cost);
            copyExpenses.add(copyExpense);
        }
        return copyExpenses;
    }

    //Effects: creates a copy of loans that can be changed independently without affecting original
    protected ArrayList<Loan> createCopyLoans(ArrayList<Loan> loans) {
        ArrayList<Loan> copyLoans = new ArrayList<>();
        for (Loan l : loans) {
            String name = l.getLoan();
            double outBal = l.getOutstandingBalance();
            int monthsToPay = l.getMonthsToPayLoan();
            double rate = l.getInterestRate();

            Loan copyLoan = new Loan(name, outBal, monthsToPay, rate);
            copyLoans.add(copyLoan);
        }
        return copyLoans;
    }

}
