package model;
// an extremely simple model of a stock portfolio

import org.json.JSONObject;
import persistence.Writable;

public class Portfolio implements Writable {


    private double capital;
    private double estimatedRoi;
    private double dividendPaymentPercent; //dividends payed annually


    //constructor
    public Portfolio(double capital, double estimatedRoi, double dividendPaymentPercent) {
        this.capital = capital;
        this.estimatedRoi = estimatedRoi;
        this.dividendPaymentPercent = dividendPaymentPercent;
    }

    //Requires: amount >= 0
    //Modifies: this
    //Effects: updates capital by adding amount to it
    public void invest(double amount) {
        this.capital += amount;
    }

    //Modifies: This
    //Effects: increases the value of the capital by estimated ROI
    public void appreciateCapital() {
        this.capital = this.capital * (1 + estimatedRoi);
    }

    //Requires: all new capital invested and appreciated for that year
    //Effects: calculates annual dividend payment
    public double getDividendPayment() {
        return dividendPaymentPercent * this.capital;
    }

    public double getCapital() {
        return capital;
    }

    public double getEstimatedRoi() {
        return estimatedRoi;
    }

    public double getDividendPaymentPercent() {
        return dividendPaymentPercent;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public void setEstimatedRoi(double estimatedRoi) {
        this.estimatedRoi = estimatedRoi;
    }

    public void setDividendPaymentPercent(double dividendPaymentPercent) {
        this.dividendPaymentPercent = dividendPaymentPercent;
    }


    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("capital", capital);
        json.put("ROI", estimatedRoi);
        json.put("dividend percent", dividendPaymentPercent);

        return json;
    }
}
