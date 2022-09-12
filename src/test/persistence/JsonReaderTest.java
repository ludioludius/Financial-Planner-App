package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// code is modeled after JsonReaderTest in JsonSerializationDemo

public class JsonReaderTest extends JsonTest{

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Finance finance = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyFinancialData() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyFinancialData.json");
        try {
            Finance finance = reader.read();
            assertEquals("Financial Data", finance.getName());

            checkPortfolio(new Portfolio(0,0,0), finance.getPortfolio());
            checkRealEstate(new RealEstate(0,0,0,0),
                    finance.getProperty());
            checkSalary(new Salary(0,0,0,0),
                    finance.getSalary());
            checkSavingsAccount(new SavingsAccount(0,0),finance.getSavings());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderFinancialData() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralFinancialData.json");
        try {

            Finance finance = reader.read();

            checkPortfolio(new Portfolio(10000, 0.05, 0.01),
                    finance.getPortfolio());

            checkRealEstate(new RealEstate(0.01, 2000,
                    12000, 150000),finance.getProperty());

            checkSalary(new Salary(100000, 0.5,
                    0.01, 0.20),finance.getSalary());

            checkSavingsAccount(new SavingsAccount(50000, 0.01), finance.getSavings());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
