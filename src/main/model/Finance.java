package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//represents the users financial information, essentially a financial summary
public class Finance implements Writable {

    private ArrayList<Loan> loans = new ArrayList<>();
    private ArrayList<Expense> expenses = new ArrayList<>();
    private AnnualBudget annualBudget = new AnnualBudget(expenses, loans);

    private String name;

    private Portfolio portfolio = new Portfolio(0.0, 0, 0.0);
    private RealEstate property = new RealEstate(0, 0, 0, 0);
    private Salary salary = new Salary(0, 0, 0, 0);
    private SavingsAccount savings = new SavingsAccount(0, 0);

//private AnnualBudget annualBudget;

    public AnnualBudget getAnnualBudget() {
        return annualBudget;
    }

    public void setAnnualBudget(AnnualBudget annualBudget) {
        this.annualBudget = annualBudget;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    //Effects: constructs A Finance object
    public Finance(String name) {
        this.name = name;
    }


    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("name", name);
        json.put("loans", loansToJson());
        json.put("expenses", expensesToJson());
        json.put("portfolio", portfolio.toJson());
        json.put("property", property.toJson());
        json.put("salary", salary.toJson());
        json.put("savings", savings.toJson());
//      json.put("annual budget", annualBudget.toJson());

        return json;
    }


    private JSONArray loansToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Loan l : this.loans) {
            jsonArray.put(l.toJson());
        }
        return jsonArray;
    }

    private JSONArray expensesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Expense e : this.expenses) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }

    //Modifies: this
    //Effects: adds a loan to loans in finance
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    //Modifies: this
    //Effects: adds a loan to loans in finance
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    //Modifies: this
    //Effects: sets the portfolio in finance
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    //Modifies: this
    //Effects: sets the real estate in finance
    public void setRealEstate(RealEstate property) {
        this.property = property;
    }

    //Modifies: this
    //Effects: sets the salary in finance
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    //Modifies: this
    //Effects: sets the savings account in finance
    public void setSavingsAccount(SavingsAccount savings) {
        this.savings = savings;
    }

    public String getName() {
        return this.name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public RealEstate getProperty() {
        return property;
    }

    public Salary getSalary() {
        return salary;
    }

    public SavingsAccount getSavings() {
        return savings;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
