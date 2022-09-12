package model;

import java.util.ArrayList;

//total summary of all money lost in one year (all money spent)

public class AnnualBudget {


    private static double INFLATION = 0.01;

    //public ArrayList<Expense> getExpenses() {
    //    return expenses;
    //}
    private ArrayList<Expense> expenses;
    private ArrayList<Loan> loans;


    public AnnualBudget(ArrayList<Expense> expenses, ArrayList<Loan> loans) {
        this.expenses = expenses;
        this.loans = loans;
    }

    //Modifies: expenses and expense
    //effects: sums up all the expenses in expenses in a year and increases the cost of expenses by the inflation rate
    public Double sumAndUpdateAllExpenses() {
        double sum = 0;
        for (Expense e : expenses) {
            sum += (e.getCost() * 12); //changed, test should fail
            e.inflateCost(INFLATION);
        }
        return sum;
    }

    //modifies: Loans and loan
    //effects: sums up all the loan payments made in loans in a year changes loan object and makes pays the loan
    public Double sumAllLoanPayments() {
        double sum = 0;
        for (Loan l : loans) {
            for (int i = 1; i <= 12; i++) {
                sum += l.monthlyPayment();
                l.makeMonthlyPayment();
            }
        }
        return sum; //stub
    }

    //Effects: sums up all the expenses and loan payments made in  year
    public double totalAnnualBudget() {
        return this.sumAndUpdateAllExpenses() + this.sumAllLoanPayments();
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    /*
        @Override
        public JSONObject toJson() {
            JSONObject json = new JSONObject();

            json.put("expenses", expensesToJson());
            json.put("loans", loansToJson());

            return json;
        }

        private JSONArray expensesToJson() {
            JSONArray jsonArray = new JSONArray();

            for (Expense e : this.getExpenses()) {
                jsonArray.put(e.toJson());
            }

            return jsonArray;
        }

        private JSONArray loansToJson() {
            JSONArray jsonArray = new JSONArray();

            for (Loan l : this.getLoans()) {
                jsonArray.put(l.toJson());
            }

            return jsonArray;
        }
    */
    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }

    public void setLoans(ArrayList<Loan> loans) {
        this.loans = loans;
    }


    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
