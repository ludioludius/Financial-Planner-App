package model;

import org.json.JSONObject;
import persistence.Writable;

public class Salary implements Writable {


    private double grossSalary;
    private double percentNetSalaryInvested;
    private double averageAnnualSalaryGrowthRate;
    private double estimatedTaxPercent;

    //^^^ user inputs

    //constructs salary object
    public Salary(double grossSalary,
                  double percentNetSalaryInvested,
                  double averageAnnualSalaryGrowthRate,
                  double estimatedTaxPercent) {
        this.grossSalary = grossSalary;
        this.percentNetSalaryInvested = percentNetSalaryInvested;
        this.averageAnnualSalaryGrowthRate = averageAnnualSalaryGrowthRate;
        this.estimatedTaxPercent = estimatedTaxPercent;
    }

    //Requires: Salary has been increased that year
    //Effects: calculates the net income (gross income - taxes)
    public double calculateNetIncome() {
        return this.grossSalary * (1 - estimatedTaxPercent);
    }

    //Requires: Salary has been increased that year
    //Effects: calculates the net income invested annually
    public double incomeInvestedAnnually() {
        return (this.calculateNetIncome() * percentNetSalaryInvested);
    }

    //Requires: Salary has been increased that year
    //Effects: calculates the net income saved annually
    public double incomeSavedAnnually() {
        return this.calculateNetIncome() - this.incomeInvestedAnnually();
    }

    //Modifies: this
    //Effects: increases gross salary by averageAnnualSalaryGrowthRate
    public void increaseSalary() {
        this.grossSalary = this.grossSalary * (1 + this.averageAnnualSalaryGrowthRate);
    }


    public double getGrossSalary() {
        return grossSalary;
    }

    public double getEstimatedTaxPercent() {
        return this.estimatedTaxPercent;
    }

    public double getPercentNetSalaryInvested() {
        return percentNetSalaryInvested;
    }

    public double getAverageAnnualSalaryGrowthRate() {
        return this.averageAnnualSalaryGrowthRate;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setPercentNetSalaryInvested(double percentNetSalaryInvested) {
        this.percentNetSalaryInvested = percentNetSalaryInvested;
    }

    public void setAverageAnnualSalaryGrowthRate(double averageAnnualSalaryGrowthRate) {
        this.averageAnnualSalaryGrowthRate = averageAnnualSalaryGrowthRate;
    }

    public void setEstimatedTaxPercent(double estimatedTaxPercent) {
        this.estimatedTaxPercent = estimatedTaxPercent;
    }

    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("gross salary", grossSalary);
        json.put("percent net salary invested", percentNetSalaryInvested);
        json.put("average annual salary growth rate", averageAnnualSalaryGrowthRate);
        json.put("estimated tax percent", estimatedTaxPercent);


        return json;
    }
}
