package ui;

import model.Expense;
import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//provides functionality to expense button for adding expenses
public class ExpenseButton implements ActionListener {
    private JTextField expense;
    private JTextField cost;
    private Finance finance;

    public ExpenseButton(JTextField expense, JTextField cost, Finance finance) {
        this.expense = expense;
        this.cost = cost;
        this.finance = finance;
    }

    @Override
    //Modifies: finance
    //Effects: adds an expense to finance on click
    public void actionPerformed(ActionEvent e) {
        ArrayList<Expense> temp = new ArrayList<Expense>();
        Expense exp = new Expense(expense.getText(), Double.parseDouble(cost.getText()));
        finance.getExpenses().add(exp);
        System.out.println(finance.getExpenses());
    }
}
