package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


//modeled after sample
public class JsonWriterTest extends JsonTest{


    @Test
    void testWriterInvalidFile() {
        try {
            Finance finance = new Finance("Financial Data");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Finance finance = new Finance("Financial Data");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyFinanceData.json");
            writer.open();
            writer.write(finance);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyFinanceData.json");
            finance = reader.read();

           assertEquals("Financial Data", finance.getName());
           assertEquals(0, finance.getLoans().size());
           assertEquals(0, finance.getExpenses().size());



           checkPortfolio(new Portfolio(0,0,0), finance.getPortfolio());
           checkRealEstate(new RealEstate(0,0,0,0),finance.getProperty());
           checkSalary(new Salary(0,0,0,0),finance.getSalary());
           checkSavingsAccount(new SavingsAccount(0,0),finance.getSavings());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
           Finance finance = new Finance("financial Data");
           finance = createGeneralFinancialData(finance); // assigns normal data to finance

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralFinancialData.json");
            writer.open();
            writer.write(finance);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralFinancialData.json");
            finance = reader.read();


            checkExpenses(new Expense("gas", 100), finance.getExpenses().get(0));

            checkPortfolio(new Portfolio(10000, 0.05, 0.01),
                    finance.getPortfolio());

            checkRealEstate(new RealEstate(0.01, 2000,
                    12000, 150000),finance.getProperty());

            checkSalary(new Salary(100000, 0.5,
                    0.01, 0.20),finance.getSalary());

            checkSavingsAccount(new SavingsAccount(50000, 0.01), finance.getSavings());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    private Finance createGeneralFinancialData(Finance finance) {

        Portfolio portfolio = new Portfolio(10000, 0.05, 0.01);
        RealEstate property = new RealEstate(0.01, 2000, 12000, 150000);
        Salary salary = new Salary(100000, 0.5, 0.01, 0.20);
        SavingsAccount savings = new SavingsAccount(50000, 0.01);

        finance.addLoan(new Loan("car loan", 15000, 36, 0.04));
        finance.addExpense(new Expense("gas", 100));
        //finance.addExpense(new Expense("rent", 1000));
        //finance.addExpense(new Expense("food", 150));
        finance.setPortfolio(portfolio);
        finance.setRealEstate(property);
        finance.setSalary(salary);
        finance.setSavingsAccount(savings);
        return finance;
    }


}
