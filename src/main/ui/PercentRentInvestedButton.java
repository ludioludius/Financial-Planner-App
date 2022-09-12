package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality for the percent rent invested Button
public class PercentRentInvestedButton implements ActionListener {

    private JTextField percent;
    private GUI gui;

    public PercentRentInvestedButton(JTextField percent, GUI gui) {
        this.percent = percent;
        this.gui = gui;
    }


    @Override
    //Modifies: GUI
    //Effects: sets corresponding field in GUI
    public void actionPerformed(ActionEvent e) {
        gui.setPercentRentalIncomeInvested(Double.parseDouble(percent.getText()));
        System.out.println(gui.getPercentRentalIncomeInvested());
    }
}
