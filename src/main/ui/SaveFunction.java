package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

// provides functionality for the save function button
public class SaveFunction extends Function {

    public SaveFunction(JTextField years, GUI gui) {
        super(years, gui);
    }

    @Override
    //Modifies: this
    //Effects: changes fields in GUI to update the GUI
    protected void updateGUI() {
        gui.setSaveFunctionAnswer(copyFinance.getSavings().getBalance());
        gui.setSaveFunctionBool(true);
        gui.setBudgetFunctionBool(false);
        gui.setPortfolioFunctionBool(false);
    }


    @Override
    //Modifies: this
    //Effects: calculates savings in x years on click
    public void actionPerformed(ActionEvent e) {
        createCopyFinance();

        for (int i = 1; i <= Double.parseDouble(years.getText()); i++) {
            simulateOneYear(copyFinance.getSavings(), copyFinance.getSalary(), copyFinance.getPortfolio(),
                    copyFinance.getProperty(), copyFinance.getAnnualBudget(),
                    (1 - gui.getPercentPortfolioInvested()), (1 - gui.getPercentRentalIncomeInvested()));
        }
        updateGUI();
    }


}
