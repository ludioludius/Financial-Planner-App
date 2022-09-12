package ui;

import model.Finance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// provides functionality to the salary button
public class SalaryButton implements ActionListener {
    private JTextField salary;
    private JTextField percent;
    private JTextField avg;
    private JTextField tax;
    private Finance finance;


    public SalaryButton(JTextField s, JTextField perc, JTextField avg, JTextField tax, Finance finance) {
        this.salary = s;
        this.percent = perc;
        this.avg = avg;
        this.tax = tax;
        this.finance = finance;

    }


    @Override
    //Modifies: finance
    //Effects: sets the salary fields to corresponding values
    public void actionPerformed(ActionEvent e) {
        finance.getSalary().setGrossSalary(Double.parseDouble(salary.getText()));
        finance.getSalary().setEstimatedTaxPercent(Double.parseDouble(tax.getText()));
        finance.getSalary().setAverageAnnualSalaryGrowthRate(Double.parseDouble(avg.getText()));
        finance.getSalary().setPercentNetSalaryInvested(Double.parseDouble(percent.getText()));
    }
}

