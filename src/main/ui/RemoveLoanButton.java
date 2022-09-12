package ui;

import model.Finance;
import model.Loan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality to the remove loan button
public class RemoveLoanButton implements ActionListener {
    private JTextField loan;
    private JTextField outstandingBalance;
    private JTextField interestRate;
    private JTextField monthsToPayLoan;
    private Finance finance;


    public RemoveLoanButton(JTextField loan, JTextField outstandingBalance, JTextField interestRate,
                      JTextField monthsToPayLoan, Finance finance) {
        this.loan = loan;
        this.outstandingBalance = outstandingBalance;
        this.interestRate = interestRate;
        this.monthsToPayLoan = monthsToPayLoan;
        this.finance = finance;
    }

    @Override
    //Modifies: finance
    //Effects: removes loan from expenses on click
    public void actionPerformed(ActionEvent e) {
        Loan target = new Loan(this.loan.getText(), Double.parseDouble(this.outstandingBalance.getText()),
                Integer.parseInt(this.monthsToPayLoan.getText()),
                Double.parseDouble(this.interestRate.getText()));
        for (Loan loan : finance.getLoans()) {

            if (loan.equals(target)) {
                finance.getLoans().remove(loan);
            }

        }
        System.out.println(finance.getLoans());
    }

}
