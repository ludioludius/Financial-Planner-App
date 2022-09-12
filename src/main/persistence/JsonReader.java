package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/* code is modeled after JsonReader class in JsonSerializationDemo */

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads finance from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Finance read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseFinance(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Finance from JSON object and returns it
    // ie. sets the values of all finance fields and returns it
    private Finance parseFinance(JSONObject jsonObject) {
        String name = jsonObject.getString("name"); /////
        Finance finance = new Finance(name);
        addLoans(finance, jsonObject);
        addExpenses(finance, jsonObject);
        addPortfolio(finance, jsonObject.getJSONObject("portfolio"));
        addRealEstate(finance, jsonObject.getJSONObject("property"));
        addSalary(finance, jsonObject.getJSONObject("salary"));
        addSavings(finance, jsonObject.getJSONObject("savings"));

        return finance;
    }




    //  HELPERS HELPERS HELPERS HELPERS HELPERS HELPERS





    // MODIFIES: finance
    // EFFECTS: parses loans from JSON object and adds them to finance
    //          and sets the loans field of finance.annualBudget
    private void addLoans(Finance finance, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("loans");
        for (Object json : jsonArray) {
            JSONObject loan = (JSONObject) json;
            addloan(finance, loan); //loan is added to finance.loans
        }
    }

    // MODIFIES: finance
    // EFFECTS: parses loan from JSON object and adds it to finance
    private void addloan(Finance finance, JSONObject jsonObject) {
        String loan = jsonObject.getString("loan");
        Double outstandingBalance = jsonObject.getDouble("outstanding balance");
        int monthsToPayLoan = jsonObject.getInt("months to pay loan");
        Double interestRate = jsonObject.getDouble("interest rate");

        Loan loan1 = new Loan(loan, outstandingBalance, monthsToPayLoan, interestRate);
        finance.addLoan(loan1); //finance.add loan adds a loan to loans
    }

    // MODIFIES: finance
    // EFFECTS: parses expenses from JSON object and adds them to finance
    //
    private void addExpenses(Finance finance, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("expenses");
        for (Object json : jsonArray) {
            JSONObject expense = (JSONObject) json;
            addExpense(finance, expense); //expense is added to finance.expenses
        }
    }

    // MODIFIES: finance
    // EFFECTS: parses expense from JSON object and adds it to finance
    private void addExpense(Finance finance, JSONObject jsonObject) {
        String expense = jsonObject.getString("expense");
        Double cost = jsonObject.getDouble("cost");

        Expense expense1 = new Expense(expense, cost);
        finance.addExpense(expense1); //finance.addexpense adds an expense to expenses
    }

    //Modifies: Finance
    //Effects: parses portfolio json object and adds it to finance
    private void addPortfolio(Finance finance, JSONObject jsonObject) {

        Double capital = jsonObject.getDouble("capital");
        Double estimatedRoi = jsonObject.getDouble("ROI");
        Double dividendPaymentPercent = jsonObject.getDouble("dividend percent");

        Portfolio portfolio = new Portfolio(capital, estimatedRoi, dividendPaymentPercent);
        finance.setPortfolio(portfolio);
    }

    //Modifies: Finance
    //Effects: parses real estate json object and adds it to finance
    private void addRealEstate(Finance finance, JSONObject jsonObject) {
        Double appreciation = jsonObject.getDouble("appreciation");
        Double costs = jsonObject.getDouble("property costs");
        Double rentalIncome = jsonObject.getDouble("rental income");
        Double valuation = jsonObject.getDouble("valuation");

        RealEstate property = new RealEstate(appreciation, costs, rentalIncome, valuation);
        finance.setRealEstate(property);
    }

    //Modifies: Finance
    //Effects: parses salary json object and adds it to finance
    private void addSalary(Finance finance, JSONObject jsonObject) {
        Double salary = jsonObject.getDouble("gross salary");
        Double percentInvested = jsonObject.getDouble("percent net salary invested");
        Double annualGrowth = jsonObject.getDouble("average annual salary growth rate");
        Double tax = jsonObject.getDouble("estimated tax percent");

        Salary salary1 = new Salary(salary, percentInvested, annualGrowth, tax);
        finance.setSalary(salary1);
    }

    //Modifies: Finance
    //Effects: parses savings account json object and adds it to finance
    private void addSavings(Finance finance, JSONObject jsonObject) {
        Double balance = jsonObject.getDouble("balance");
        Double interest = jsonObject.getDouble("interest rate");


        SavingsAccount savings = new SavingsAccount(balance, interest);
        finance.setSavingsAccount(savings);
    }


}


