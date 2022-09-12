package ui;

import model.Finance;
import model.Loan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality to loan button for adding loans
public class LoanButton implements ActionListener {

    private JTextField loan;
    private JTextField outstandingBalance;
    private JTextField interestRate;
    private JTextField monthsToPayLoan;
    private Finance finance;


    public LoanButton(JTextField loan, JTextField outstandingBalance, JTextField interestRate,
                            JTextField monthsToPayLoan, Finance finance) {
        this.loan = loan;
        this.outstandingBalance = outstandingBalance;
        this.interestRate = interestRate;
        this.monthsToPayLoan = monthsToPayLoan;
        this.finance = finance;
    }

    @Override
    //Modifies: finance
    //Effects: adds a loan to finance on click
    public void actionPerformed(ActionEvent e) {
        Loan temp = new Loan(loan.getText(), Double.parseDouble(outstandingBalance.getText()),
                Integer.parseInt(monthsToPayLoan.getText()), Double.parseDouble(interestRate.getText()));
        finance.getLoans().add(temp);
        System.out.println(finance.getLoans());
    }
}
