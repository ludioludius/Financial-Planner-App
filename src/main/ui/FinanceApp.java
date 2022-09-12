/*
package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FinanceApp {

    private static final String JSON_STORE = "./data/MainJason.json";
    private static final String name = "Financial Data";

    private Finance finance = new Finance(name);

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Scanner input;
    private Scanner input2;
    private Scanner input3;
    private Scanner input4;


    // EFFECTS: runs the financial simulator application
    public FinanceApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        mainMenu();

    }

    //Effects: displays main menu
    private void mainMenu() {
        int option;
        input = new Scanner(System.in);
        System.out.println("(1) -------> Build new data");     //calls builder, builder calls main menu at the end
        System.out.println("(2) -------> save current data");  //saves data and calls mainMenu
        System.out.println("(3) -------> load data from file");  //loads data and calls mainMenu
        System.out.println("(4) -------> simulate with current data"); //runs the simulator, returns to main menu
        System.out.println("type quit to close application");
        option = input.nextInt();
        processOption(option);
    }

    //Effects: processes option entered in main menu
    private void processOption(int option) {
        if (option == 1) {
            finance = new Finance(name);
            builder();
        } else if (option == 2) {
            saveData();
        } else if (option == 3) {
            loadData();
        } else if (option == 4) {
            simulator();
        } else {
            mainMenu();
        }
    }


    //inspired from sample
    //Effects: saves data to file
    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(finance);
            jsonWriter.close();
            System.out.println("Saved " + finance.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        mainMenu();
    }

    //inspired from sample
    //Effects: saves data to file
    private void loadData() {
        try {
            finance = jsonReader.read();
            System.out.println("Loaded " + finance.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        mainMenu();
    }

    //Effects: displays the options to pick from, then processes choice i.e the  menu where simulations are made
    private void simulator() {
        String choice;
        boolean loop = true;
        Scanner x = new Scanner(System.in);

        while (loop) {
            displayMenu();
            choice = x.nextLine();

            if (choice.equals("quit")) {
                loop = false;
            } else {
                processChoice(choice);
            }
        }

        mainMenu();

    }

    //Effects: displays the options to pick from
    private void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1" + "-->" + "display annual budget x years from now");
        System.out.println("2" + "-->" + "display Savings Balance x years from now");
        System.out.println("3" + "-->" + "display status of loans x years from now");
        System.out.println("4" + "-->" + "how many years will it take to save up x amount of money");
        System.out.println("5" + "-->" + "determine investment portfolio value x years from now");
        System.out.println("quit");

    }

    //Effects: displays the options to pick from
    private void processChoice(String c) {
        if (c.equals("1")) {
            System.out.println(getBudgetInXYears().toString());
        } else if (c.equals("2")) {
            System.out.println(displaySavingsBalance());
        } else if (c.equals("3")) {
            calculateLoanStatus();
        } else if (c.equals("4")) {
            System.out.println(calculateYearsToSave());
        } else if (c.equals("5")) {
            System.out.println(getPortfolioCapitalInXYears());
        }
    }


    //Effects: calculates the future budget given x years(user input)
    private Double getBudgetInXYears() {
        AnnualBudget b = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                createCopyLoans(finance.getLoans()));
        input = new Scanner(System.in);
        System.out.println("x = ?");
        int x = input.nextInt();
        System.out.println("Expected inflation: ");
        double i = input.nextDouble();

        for (int j = 1; j <= x; j++) {
            for (Expense e : b.getExpenses()) {
                e.inflateCost(i / 100);
            }
        }

        for (int k = 1; k <= x; k++) {
            for (Loan l : b.getLoans()) {
                for (int j = 1; j <= 12; j++) {
                    l.makeMonthlyPayment();
                }
            }
        }

        return b.totalAnnualBudget();
    }

    //Effects: creates a copy of loans that can be changed independently without affecting original
    private ArrayList<Loan> createCopyLoans(ArrayList<Loan> loans) {
        ArrayList<Loan> copyLoans = new ArrayList<>();
        for (Loan l : loans) {
            String name = l.getLoan();
            double outBal = l.getOutstandingBalance();
            int monthsToPay = l.getMonthsToPayLoan();
            double rate = l.getInterestRate();

            Loan copyLoan = new Loan(name, outBal, monthsToPay, rate);
            copyLoans.add(copyLoan);
        }
        return copyLoans;
    }

    //Effects: creates a copy of expenses that can be changed independently without affecting original
    private ArrayList<Expense> createCopyExpenses(ArrayList<Expense> expenses) {
        ArrayList<Expense> copyExpenses = new ArrayList<>();
        for (Expense e : expenses) {
            String expense = e.getExpense();
            Double cost = e.getCost();
            Expense copyExpense = new Expense(expense, cost);
            copyExpenses.add(copyExpense);
        }
        return copyExpenses;
    }


    //Effects: calculates the status and balance of loans in x years
    private void calculateLoanStatus() {
        AnnualBudget b = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                createCopyLoans(finance.getLoans()));
        input = new Scanner(System.in);
        System.out.println("x = ?");
        int x = input.nextInt();


        for (int i = 1; i <= x; i++) {
            for (Loan l : b.getLoans()) {
                for (int j = 1; j <= 12; j++) {
                    l.makeMonthlyPayment();
                }
            }
        }

        for (Loan l : b.getLoans()) {
            if (l.getStatus()) {
                System.out.println(l.getLoan() + " is open " + "outstanding balance: " + l.getOutstandingBalance());
            } else {
                System.out.println(l.getLoan() + "is closed");
            }
        }

    }


    //Effects: determines how many years it takes to save up an amount of money
    private int calculateYearsToSave() {
        input = new Scanner(System.in);
        System.out.println("x = ?");
        double x = input.nextDouble();
        int counter = 0;
        System.out.println("Percent stock dividends saved?\n\n" + "Percent rental income saved?");
        double sd = input.nextDouble();
        double in = input.nextDouble();

        AnnualBudget b = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                createCopyLoans(finance.getLoans()));

        Salary s = new Salary(finance.getSalary().getGrossSalary(), finance.getSalary().getPercentNetSalaryInvested(),
                finance.getSalary().getAverageAnnualSalaryGrowthRate(), finance.getSalary().getEstimatedTaxPercent());

        SavingsAccount sav = new SavingsAccount(finance.getSavings().getBalance(),
                finance.getSavings().getInterestRate());

        Portfolio p = new Portfolio(finance.getPortfolio().getCapital(), finance.getPortfolio().getEstimatedRoi(),
                finance.getPortfolio().getDividendPaymentPercent());

        RealEstate r = new RealEstate(finance.getProperty().getEstimatedAppreciation(),
                finance.getProperty().getPropertyCosts(), finance.getProperty().getRentalIncome(),
                finance.getProperty().getValuation());


        while (x >= sav.getBalance()) {
            simulateOneYear(sav, s, p, r, b, sd, in);
            counter++;
        }
        return counter;

    }


    //Effects: calculates balance in savings account in x years based on user input
    private double displaySavingsBalance() {
        input = new Scanner(System.in);
        System.out.println("x = ?");
        int x = input.nextInt();
        System.out.println("Percent stock dividends saved?");
        double sd = input.nextDouble();
        System.out.println("Percent rental income saved?");
        double in = input.nextDouble();

        AnnualBudget b = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                createCopyLoans(finance.getLoans()));

        Salary s = new Salary(finance.getSalary().getGrossSalary(), finance.getSalary().getPercentNetSalaryInvested(),
                finance.getSalary().getAverageAnnualSalaryGrowthRate(), finance.getSalary().getEstimatedTaxPercent());

        SavingsAccount sav = new SavingsAccount(finance.getSavings().getBalance(),
                finance.getSavings().getInterestRate());

        Portfolio p = new Portfolio(finance.getPortfolio().getCapital(), finance.getPortfolio().getEstimatedRoi(),
                finance.getPortfolio().getDividendPaymentPercent());

        RealEstate r = new RealEstate(finance.getProperty().getEstimatedAppreciation(),
                finance.getProperty().getPropertyCosts(),
                finance.getProperty().getRentalIncome(), finance.getProperty().getValuation());


        for (int i = 1; i <= x; i++) {
            simulateOneYear(sav, s, p, r, b, sd, in);
        }
        return sav.getBalance();
    }

    //Effects: simulates the state of finances after 1 year
    private void simulateOneYear(SavingsAccount sav, Salary s, Portfolio p, RealEstate r,
                                 AnnualBudget b, Double dividendSaved, Double rentSaved) {
        double inc = s.calculateNetIncome() - b.totalAnnualBudget();

        sav.deposit(inc * (1 - (s.getPercentNetSalaryInvested()))); //make get percent salary saved method?
        p.invest(inc * (s.getPercentNetSalaryInvested()));

        sav.deposit((p.getDividendPayment()) * (dividendSaved / 100));
        p.invest(p.getDividendPayment() * (1 - (dividendSaved / 100)));

        sav.deposit(r.netAnnualRentalIncome() * (rentSaved / 100));
        p.invest(r.netAnnualRentalIncome() * (1 - (rentSaved / 100)));

        p.appreciateCapital();
        sav.applyInterestRate();
        s.increaseSalary();
    }


    //Effects: calculates capital in portfolio in x years based on user input
    private double getPortfolioCapitalInXYears() {
        input = new Scanner(System.in);
        System.out.println("x = ?");
        int x = input.nextInt();
        System.out.println("Percent stock dividends invested?");
        double sd = input.nextDouble();
        System.out.println("Percent rental income invested?");
        double in = input.nextDouble();

        AnnualBudget b = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                createCopyLoans(finance.getLoans()));
        Salary s = new Salary(finance.getSalary().getGrossSalary(), finance.getSalary().getPercentNetSalaryInvested(),
                finance.getSalary().getAverageAnnualSalaryGrowthRate(), finance.getSalary().getEstimatedTaxPercent());
        SavingsAccount sav = new SavingsAccount(finance.getSavings().getBalance(),
                finance.getSavings().getInterestRate());
        Portfolio p = new Portfolio(finance.getPortfolio().getCapital(), finance.getPortfolio().getEstimatedRoi(),
                finance.getPortfolio().getDividendPaymentPercent());
        RealEstate r = new RealEstate(finance.getProperty().getEstimatedAppreciation(),
                finance.getProperty().getPropertyCosts(),
                finance.getProperty().getRentalIncome(), finance.getProperty().getValuation());

        for (int i = 1; i <= x; i++) {
            simulateOneYear(sav, s, p, r, b, sd, in);
        }
        return p.getCapital();

    }

    //Modifies: Finance
    //Effects: builds a financial profile based on user input
    private void builder() {
        input = new Scanner(System.in);
        input2 = new Scanner(System.in);
        input3 = new Scanner(System.in);
        input4 = new Scanner(System.in);
        System.out.println("\nFirst, you must enter your finances, you will now be able to enter"
                + "your financial information");
        System.out.println("The following order will be followed \n monthly expenses"
                + "\n loans \n Salary information"
                + "\n portfolio \n Real Estate Investments");
        System.out.println("\nType yes to begin entering your financial information");
        String answer = input.nextLine();

        builderHelper(answer, input2, input3, input4);

    }

    // continued execution of builder();
    private void builderHelper(String answer, Scanner input2, Scanner input3, Scanner input4) {
        if (answer.equals("yes")) {

            buildExpenses();

            System.out.println("Do you have any loans?");
            String x = input2.nextLine();
            if (x.equals("yes")) {
                buildLoans();
            }
            buildSalary();

            System.out.println("Portfolio?");
            String x1 = input3.nextLine();
            if (x1.equals("yes")) {
                buildPortfolio();
            }

            System.out.println("Do you own any real estate?");
            String x2 = input4.nextLine();
            if (x2.equals("yes")) {
                buildRealEstate();
            }

            buildSavingsAccount();
            mainMenu();
        }
    }

    //Modifies: Finance
    //Effects: builds a list of expenses based on user input
    private void buildExpenses() {
        boolean keepBuildingExpenses = true;
        while (keepBuildingExpenses) {    //creates an expense, adds it to budget expenses
            input = new Scanner(System.in);
            Scanner exit = new Scanner(System.in);

            Expense e = new Expense("", 0);

            System.out.println("Enter expense type: ");
            e.setExpense(input.nextLine());

            System.out.println("Enter cost: ");
            e.setCost(input.nextDouble());

            finance.addExpense(e);

            System.out.println("Type yes to add an expense, type no to stop adding expenses");
            String answer = exit.nextLine();
            if (answer.equals("no")) {
                keepBuildingExpenses = false;
            }
        }

    }


    //Modifies: Finance
    //Effects: builds list of loans based on user input
    private void buildLoans() {
        boolean keepBuildingLoans = true;
        while (keepBuildingLoans) {
            Scanner in = new Scanner(System.in);
            Scanner exit = new Scanner(System.in);
            Scanner x = new Scanner(System.in);
            Loan l = new Loan("", 0.0, 0, 0.0);
            System.out.println("Enter loan: (give a name to the loan)");
            l.setLoan(in.nextLine());
            System.out.println("Enter outstanding balance: ");
            l.setOutstandingBalance(x.nextDouble());
            System.out.println("Enter months to pay loan: ");
            l.setMonthsToPayLoan(in.nextInt());
            System.out.println("Enter interest rate: ");
            l.setInterestRate(in.nextDouble() / 100);
            finance.addLoan(l);
            System.out.println("Type yes to add another loan, type no to stop adding loans");
            String answer = exit.nextLine();
            if (answer.equals("no")) {
                keepBuildingLoans = false;
            }
        }

    }

    //Modifies: Finance
    //Effects: builds salary based on user input
    private void buildSalary() {
        input = new Scanner(System.in);

        System.out.println("Salary");

        System.out.println("Enter Gross Salary: (salary before and deductions are made)");
        finance.getSalary().setGrossSalary(input.nextDouble());

        System.out.println("Enter percent of net salary to be invested");
        finance.getSalary().setPercentNetSalaryInvested((input.nextDouble() / 100));

        System.out.println("Enter your average annual salary growth rate:");
        finance.getSalary().setAverageAnnualSalaryGrowthRate(input.nextDouble() / 100);

        System.out.println("Enter estimated tax rate: (including social security, pension funds etc.)");
        finance.getSalary().setEstimatedTaxPercent(input.nextDouble() / 100);

    }

    //Modifies: Finance
    //Effects: Builds a portfolio based on user inputs
    private void buildPortfolio() {
        input = new Scanner(System.in);

        System.out.println("Portfolio");

        System.out.println("Enter current capital: ");
        finance.getPortfolio().setCapital(input.nextDouble());

        System.out.println("Enter estimated annual return on investment: ");
        finance.getPortfolio().setEstimatedRoi(input.nextDouble() / 100);

        System.out.println("Enter percent of capital payed as dividends");
        finance.getPortfolio().setDividendPaymentPercent(input.nextDouble() / 100);
    }

    //Modifies: Finance
    //Effects: Builds a property based on user inputs
    private void buildRealEstate() {
        input = new Scanner(System.in);

        System.out.println("Real Estate");

        System.out.println("Enter property value: ");
        finance.getProperty().setValuation(input.nextDouble());

        System.out.println("Enter estimated annual property costs: (property tax, repairs etc)");
        finance.getProperty().setPropertyCosts(input.nextDouble());

        System.out.println("Enter rental income(annual): ");
        finance.getProperty().setRentalIncome(input.nextDouble());

        System.out.println("Enter estimated annual appreciation(%): ");
        finance.getProperty().setEstimatedAppreciation(input.nextDouble() / 100);

    }

    //Modifies: Finance
    //Effects: Builds a SavingsAccount based on user inputs
    private void buildSavingsAccount() {
        input = new Scanner(System.in);

        System.out.println("Savings Account");

        System.out.println("Enter balance left in savings account:");
        finance.getSavings().setBalance(input.nextDouble());

        System.out.println("Enter annual interest rate: ");
        finance.getSavings().setInterestRate(input.nextDouble() / 100);

    }


}

*/