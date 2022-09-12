package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RealEstateTest {
    private RealEstate testRealEstate;

    @BeforeEach
    public void setup() {
        testRealEstate = new RealEstate(0.02, 2000, 24000, 100000);

    }

    @Test
    public void testAppreciateProperty() {
        double x = testRealEstate.getValuation() * (1 + testRealEstate.getEstimatedAppreciation());
        assertEquals(x, testRealEstate.appreciateProperty());
    }

    @Test
    public void testNetAnnualRentalIncome() {
        double x = testRealEstate.getRentalIncome() - testRealEstate.getPropertyCosts();
        assertEquals(x, testRealEstate.netAnnualRentalIncome());
    }
    @Test
    public void testSetters() {
        testRealEstate.setEstimatedAppreciation(0.05);
        testRealEstate.setPropertyCosts(10000);
        testRealEstate.setRentalIncome(15000);
        testRealEstate.setValuation(500000);

        assertEquals(0.05, testRealEstate.getEstimatedAppreciation());
        assertEquals(10000, testRealEstate.getPropertyCosts());
        assertEquals(15000, testRealEstate.getRentalIncome());
        assertEquals(500000, testRealEstate.getValuation());
    }


}
