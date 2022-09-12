package ui;

import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality for the savings button
public class SavingsButton implements ActionListener {
    private JTextField savings;
    private JTextField rate;
    private Finance finance;

    public SavingsButton(JTextField savings, JTextField rate, Finance finance) {
        this.savings = savings;
        this.rate = rate;
        this.finance = finance;
    }


    @Override
    //Modifies: finance
    //Effects: sets the savings account fields to corresponding values
    public void actionPerformed(ActionEvent e) {
        finance.getSavings().setBalance(Double.parseDouble(savings.getText()));
        finance.getSavings().setInterestRate(Double.parseDouble(rate.getText()));
        System.out.println(finance.getSavings().getBalance());
        System.out.println(finance.getSavings().getInterestRate());
    }
}
