package ui;

import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality for the real estate button
public class RealEstateButton implements ActionListener {
    private JTextField valuation;
    private JTextField propertyCosts;
    private JTextField estimatedAppreciation;
    private JTextField rentalIncome;
    private Finance finance;


    public RealEstateButton(JTextField valuation, JTextField propertyCosts, JTextField estimatedAppreciation,
                            JTextField rentalIncome, Finance finance) {
        this.valuation = valuation;
        this.propertyCosts = propertyCosts;
        this.estimatedAppreciation = estimatedAppreciation;
        this.rentalIncome = rentalIncome;
        this.finance = finance;
    }

    @Override
    //Modifies: finance
    //Effects: sets the real estate fields to corresponding values
    public void actionPerformed(ActionEvent e) {
        finance.getProperty().setValuation(Double.parseDouble(valuation.getText()));
        finance.getProperty().setPropertyCosts(Double.parseDouble(propertyCosts.getText()));
        finance.getProperty().setEstimatedAppreciation(Double.parseDouble(estimatedAppreciation.getText()));
        finance.getProperty().setRentalIncome(Double.parseDouble(rentalIncome.getText()));
        System.out.println(finance.getProperty().getValuation());
        System.out.println(finance.getProperty().getPropertyCosts());
        System.out.println(finance.getProperty().getEstimatedAppreciation());
        System.out.println(finance.getProperty().getRentalIncome());
    }
}
