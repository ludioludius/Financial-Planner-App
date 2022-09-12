package model;

// models a savings account

import org.json.JSONObject;
import persistence.Writable;

public class SavingsAccount implements Writable {


    private double balance;
    private double interestRate;


    //constructor
    public SavingsAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    //Requires: amount >= 0
    //Modifies: this
    //Effects: removes amount from balance
    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    //Requires: amount >= 0
    //Modifies: this
    //Effects: adds amount to balance
    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    //Modifies: this
    //Effects: produces the result of increasing the balance by the interest rate
    public void applyInterestRate() {
        this.balance = this.balance * (1 + this.interestRate);
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("balance", balance);
        json.put("interest rate", interestRate);

        return json;
    }
}
