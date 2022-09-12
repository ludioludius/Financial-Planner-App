package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTest {
    private Expense testExpense;

    @BeforeEach
    public void setup() {
        testExpense = new Expense("gas", 100);

    }

    @Test
    public void testInflateCostZero() {
        double x = testExpense.getCost();
        testExpense.inflateCost(0);
        assertEquals(x, testExpense.getCost());
    }

    @Test
    public void testInflateCost() {
        double x = testExpense.getCost() * (1 + 0.03);
        testExpense.inflateCost(0.03);
        assertEquals(x, testExpense.getCost());
    }

    @Test
    public void testSetExpense() {
        testExpense.setExpense("gas");
        assertEquals("gas", testExpense.getExpense());
    }

    @Test
    public void testSetCost() {
        testExpense.setCost(100.0);
        assertEquals(100.0, testExpense.getCost());

    }



}