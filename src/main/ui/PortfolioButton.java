package ui;

import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality for the portfolio button
public class PortfolioButton implements ActionListener {
    private JTextField capital;
    private  JTextField estimatedROI;
    private  JTextField dividendPaymentPercent;
    private Finance finance;

    public PortfolioButton(JTextField capital, JTextField estimatedROI, JTextField dividendPaymentPercent,
                           Finance finance) {
        this.capital = capital;
        this.estimatedROI = estimatedROI;
        this.dividendPaymentPercent = dividendPaymentPercent;
        this.finance = finance;
    }


    @Override
    //Modifies: finance
    //Effects: sets portfolio fields to corresponding values
    public void actionPerformed(ActionEvent e) {
        finance.getPortfolio().setCapital(Double.parseDouble(capital.getText()));
        finance.getPortfolio().setEstimatedRoi(Double.parseDouble(estimatedROI.getText()));
        finance.getPortfolio().setDividendPaymentPercent(Double.parseDouble(dividendPaymentPercent.getText()));
        System.out.println(finance.getPortfolio().getCapital());
        System.out.println(finance.getPortfolio().getEstimatedRoi());
        System.out.println(finance.getPortfolio().getDividendPaymentPercent());
    }
}
