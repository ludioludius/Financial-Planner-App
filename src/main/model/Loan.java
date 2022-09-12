package model;

// models existing loans a user has, including monthly payments, interest, whether the loan is closed or not.

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class Loan implements Writable {
    private String loan;
    private double outstandingBalance;
    private double interestRate;
    private int monthsToPayLoan; // in months
    private Boolean status;

    // constructs loan object
    public Loan(String loan, double outstandingBalance, int monthsToPayLoan, double interestRate) {
        this.loan = loan;
        this.outstandingBalance = outstandingBalance;
        this.monthsToPayLoan = monthsToPayLoan;
        this.interestRate = interestRate;
        status = true;
    }


    //Modifies: this
    //Effects: if the loan is still open,
    // -reduce outstanding balance by principal paid
    // -subtract monthsToPayLoan by 1
    // -close loan if new monthsToPayLoan is 0(set Status to false)
    public void makeMonthlyPayment() {
        if (status) {
            this.outstandingBalance = this.outstandingBalance - this.outstandingBalance / this.monthsToPayLoan;
            this.monthsToPayLoan -= 1;
        }
        if (this.monthsToPayLoan == 0) {
            this.status = false;

        }
    }

    //Effects: if loan is still open: get monthly payment to be made
    public Double monthlyPayment() {
        if (status) {
            return outstandingBalance / monthsToPayLoan * (1 + interestRate);
        } else {
            return 0.0;
        }
    }


    public void setStatus(boolean b) {
        this.status = b;
    }

    public String getLoan() {
        return loan;
    }


    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public int getMonthsToPayLoan() {
        return this.monthsToPayLoan;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setLoan(String loan) {
        this.loan = loan;
    }

    public void setOutstandingBalance(double outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonthsToPayLoan(int monthsToPayLoan) {
        this.monthsToPayLoan = monthsToPayLoan;
    }

    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("loan", loan);
        json.put("outstanding balance", outstandingBalance);
        json.put("interest rate", monthsToPayLoan);
        json.put("months to pay loan", monthsToPayLoan);
        json.put("status", status);

        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Loan loan1 = (Loan) o;
        return Double.compare(loan1.outstandingBalance, outstandingBalance) == 0
                &&
                Double.compare(loan1.interestRate, interestRate) == 0
                &&
                monthsToPayLoan == loan1.monthsToPayLoan
                &&
                Objects.equals(loan, loan1.loan)
                &&
                Objects.equals(status, loan1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loan, outstandingBalance, interestRate, monthsToPayLoan, status);
    }
}
