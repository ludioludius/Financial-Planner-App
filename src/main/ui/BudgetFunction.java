package ui;

import model.Expense;
import model.Finance;
import model.Loan;

import javax.swing.*;
import java.awt.event.ActionEvent;

//provides functionality for the budget function button
public class BudgetFunction extends Function {


    public BudgetFunction(JTextField years, JTextField inflation, GUI gui) {
        super(years, gui);
        this.inflation = inflation;


    }


    @Override
    //Modifies: this
    //Effects: calculates the budget in x years on click
    public void actionPerformed(ActionEvent e) {
        copyFinance = new Finance("copy");
        createCopyFinance();
        for (int j = 1; j <= Double.parseDouble(years.getText()); j++) {
            for (Expense expense : copyFinance.getExpenses()) {
                expense.inflateCost(Double.parseDouble(inflation.getText()));
            }
        }

        for (int k = 1; k <= Double.parseDouble(years.getText()); k++) {
            for (Loan l : copyFinance.getLoans()) {
                for (int j = 1; j <= 12; j++) {
                    l.makeMonthlyPayment();
                }
            }
        }

        updateGUI();
    }


    @Override
    //Modifies: this
    //Effects: changes fields in GUI to update the GUI
    protected void updateGUI() {
        gui.setBudgetFunctionBool(true);
        gui.setPortfolioFunctionBool(false);
        gui.setSaveFunctionBool(false);

        gui.setBudgetFunctionAnswer(copyFinance.getAnnualBudget().totalAnnualBudget());
    }


}
