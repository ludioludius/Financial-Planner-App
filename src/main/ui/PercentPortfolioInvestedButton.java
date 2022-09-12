package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality for the Percent Portfolio Invested Button
public class PercentPortfolioInvestedButton implements ActionListener {
    private  JTextField percent;
    private GUI gui;

    public PercentPortfolioInvestedButton(JTextField percent, GUI gui) {
        this.percent = percent;
        this.gui = gui;
    }


    @Override
    //Modifies: GUI
    //Effects: sets corresponding field in GUI
    public void actionPerformed(ActionEvent e) {
        gui.setPercentPortfolioInvested(Double.parseDouble(percent.getText()));
        System.out.println(gui.getPercentPortfolioInvested());
    }
}
