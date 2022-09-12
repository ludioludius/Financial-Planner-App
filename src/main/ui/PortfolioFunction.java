package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PortfolioFunction extends Function {

    //provides functionality for the portfolio function button
    public PortfolioFunction(JTextField years, GUI gui) {
        super(years, gui);
    }

    @Override
    //Modifies: this
    //Effects: changes fields in GUI to update the GUI
    protected void updateGUI() {
        gui.setPortfolioFunctionAnswer(copyFinance.getPortfolio().getCapital());
        gui.setSaveFunctionBool(false);
        gui.setBudgetFunctionBool(false);
        gui.setPortfolioFunctionBool(true);
    }

    @Override
    //Modifies: this
    //Effects: calculates portfolio value in x years on click
    public void actionPerformed(ActionEvent e) {
        createCopyFinance();
        for (int i = 1; i <= Double.parseDouble(years.getText()); i++) {
            simulateOneYear(copyFinance.getSavings(), copyFinance.getSalary(), copyFinance.getPortfolio(),
                    copyFinance.getProperty(), copyFinance.getAnnualBudget(),
                    (1 - gui.getPercentPortfolioInvested()), (1 - gui.getPercentRentalIncomeInvested()));
        }
        updateGUI();//bug
    }


}
