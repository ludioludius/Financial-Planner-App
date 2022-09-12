package model;

// models monthly expenses associated with daily life, eg: groceries, gas, rent etc

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

public class Expense implements Writable {
    private String expense;
    private double cost;

    //constructor
    public Expense(String expense, double cost) {
        this.expense = expense;
        this.cost = cost;
    }

    public String getExpense() {
        return this.expense;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    //Requires: inflation rate>= 0
    //Modifies: this
    //Effects: inflates the cost of an expense
    public void inflateCost(double inflationRate) {
        this.cost = this.cost * (1 + inflationRate);
    }

    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("expense", expense);
        json.put("cost", cost);
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
        Expense expense1 = (Expense) o;
        return Double.compare(expense1.cost, cost) == 0
                && Objects.equals(expense, expense1.expense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expense, cost);
    }
}
