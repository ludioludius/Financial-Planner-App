package model;

import org.json.JSONObject;
import persistence.Writable;

public class RealEstate implements Writable {

    private double estimatedAppreciation;     //per year
    private double propertyCosts;             //per year
    private double rentalIncome;              //per year
    private double valuation;

    public RealEstate(double estimatedAppreciation, double propertyCosts, double rentalIncome,
                      double valuation) {
        this.estimatedAppreciation = estimatedAppreciation;
        this.propertyCosts = propertyCosts;
        this.rentalIncome = rentalIncome;
        this.valuation = valuation;
    }

    //Effects: increases the property value by estimatedAppreciation
    public double appreciateProperty() {
        return valuation * (1 + estimatedAppreciation);
    }

    //Requires: rentalIncome > propertyCosts
    //Effects: Calculates the net income received from a property
    public double netAnnualRentalIncome() {
        return rentalIncome - propertyCosts;
    }

    public double getEstimatedAppreciation() {
        return estimatedAppreciation;
    }

    public double getPropertyCosts() {
        return propertyCosts;
    }

    public double getRentalIncome() {
        return rentalIncome;
    }

    public double getValuation() {
        return valuation;
    }

    public void setPropertyCosts(double propertyCosts) {
        this.propertyCosts = propertyCosts;
    }

    public void setEstimatedAppreciation(double estimatedAppreciation) {
        this.estimatedAppreciation = estimatedAppreciation;
    }

    public void setRentalIncome(double rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    @Override
    // Effects: see interface Writable
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("appreciation", estimatedAppreciation);
        json.put("property costs", propertyCosts);
        json.put("rental income", rentalIncome);
        json.put("valuation", valuation);


        return json;
    }
}
