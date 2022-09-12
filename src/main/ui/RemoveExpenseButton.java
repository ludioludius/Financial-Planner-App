package ui;

import model.Expense;
import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//provides functionality to the remove expense button
public class RemoveExpenseButton implements ActionListener {

    private JTextField expense;
    private JTextField cost;
    private Finance finance;

    public RemoveExpenseButton(JTextField expense, JTextField cost, Finance finance) {
        this.expense = expense;
        this.cost = cost;
        this.finance = finance;
    }

    @Override
    //Modifies: finance
    //Effects: removes expense from expenses on click
    public void actionPerformed(ActionEvent e) {
        Expense target = new Expense(this.expense.getText(), Double.parseDouble(this.cost.getText()));
        for (Expense expense : finance.getExpenses()) {
            if (expense.equals(target)) {
                finance.getExpenses().remove(target);
            }

        }
        System.out.println(finance.getExpenses());
    }
}
