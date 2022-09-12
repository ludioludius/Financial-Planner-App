package ui;

import model.AnnualBudget;
import model.Expense;
import model.Finance;
import model.Loan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//includes data display method that displays finance object based on current state of finance object

public class GUI extends JPanel {




    protected Finance finance = new Finance("Financial Data");

    private double percentPortfolioInvested;
    private double percentRentalIncomeInvested;

    private double saveFunctionAnswer;
    private boolean saveFunctionBool;

    private double portfolioFunctionAnswer;
    private boolean portfolioFunctionBool;

    private double budgetFunctionAnswer;
    private boolean budgetFunctionBool;


    public GUI() {

        setLayout(null);
        setBackground(Color.white); //BACKGROUND COLOR
        dataEntry();
        saveAndLoad();

    }

    //Modifies: this
    //Effects: populates left side of display with buttons and Text fields
    private void dataEntry() {
        salaryDisplay();
        portFolioDisplay();
        realEstateDisplay();
        savingsAccountDisplay();
        expenseBuilder();
        loanBulider();
        setPercentInvested();
        displayOperations();
        //displayExpensesAndLoans();
    }


    //Modifies: Finance.salary
    //Effects: displays UI related to salary and sets the Finance object
    public void salaryDisplay() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;


        JLabel grossSalary = new JLabel("Gross salary");
        grossSalary.setBounds(xborder, yborder, 200, 20);
        add(grossSalary);

        JLabel percentNetSalaryInvested = new JLabel("% net salary invested");
        percentNetSalaryInvested.setBounds(xborder, yborder + height, 200, 20);
        add(percentNetSalaryInvested);

        JLabel avg = new JLabel("average annual salary growth rate");
        avg.setBounds(xborder, yborder + (2 * height), 200, 20);
        add(avg);

        JLabel tax = new JLabel("estimated tax percent");
        tax.setBounds(xborder, yborder + (3 * height), 200, 20);
        add(tax);
        salaryDisplayHelper();
    }

    // salary display helper
    private void salaryDisplayHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        JTextField salaryText = new JTextField();
        salaryText.setBounds(xborder + width, yborder, width / 2, height);
        add(salaryText);

        JTextField percentNetSalaryInvestedText = new JTextField();
        percentNetSalaryInvestedText.setBounds(xborder + width, yborder + height, 100, 20);
        add(percentNetSalaryInvestedText);

        JTextField avgText = new JTextField();
        avgText.setBounds(xborder + width, yborder + (2 * height), 100, 20);
        add(avgText);

        JTextField taxText = new JTextField();
        taxText.setBounds(xborder + width, yborder + (3 * height), 100, 20);
        add(taxText);

        JButton saveSalary = new JButton("Set Salary");
        saveSalary.setBounds(xborder, yborder + (3 * height) + 20, 200, 20);


        //sets fields in button class, create method to extract fields and set finance
        saveSalary.addActionListener(new SalaryButton(salaryText, percentNetSalaryInvestedText, avgText,
                taxText, finance));


        add(saveSalary);


    }

    //Modifies: Finance.portfolio
    //Effects: populates the left panel with UI related to portfolio
    public void portFolioDisplay() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;
        int shift = 120;

        JLabel capital = new JLabel("Capital:");
        capital.setBounds(xborder, yborder + shift, 200, 20);
        add(capital);

        JLabel estimatedRoi = new JLabel("ROI:");
        estimatedRoi.setBounds(xborder, yborder + height + shift, 200, 20);
        add(estimatedRoi);


        JLabel dividendPaymentPercent = new JLabel("Dividend payment percent:");
        dividendPaymentPercent.setBounds(xborder, yborder + (2 * height) + shift, 200, 20);
        add(dividendPaymentPercent);

        portFolioDisplayHelper();

    }

    private void portFolioDisplayHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120;

        JTextField capitalText = new JTextField();
        capitalText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(capitalText);

        JTextField estimatedRoiText = new JTextField();
        estimatedRoiText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(estimatedRoiText);

        JTextField dividendPaymentPercentText = new JTextField();
        dividendPaymentPercentText.setBounds(xborder + width, yborder + (2 * height) + shift, 100, 20);
        add(dividendPaymentPercentText);

        JButton savePortfolio = new JButton("Enter Portfolio:");
        savePortfolio.setBounds(xborder, yborder + (3 * height) + 20 + shift, 200, 20);
        savePortfolio.addActionListener(new PortfolioButton(capitalText, estimatedRoiText, dividendPaymentPercentText,
                finance));
        add(savePortfolio);

    }

    //Modifies: Finance.realEstate
    //Effects: populates the Screen with UI related to Real Estate
    public void realEstateDisplay() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120;


        JLabel valuation = new JLabel("Property valuation:");
        valuation.setBounds(xborder, yborder + shift, 200, 20);
        add(valuation);


        JLabel propertyCosts = new JLabel("Property Costs:");
        propertyCosts.setBounds(xborder, yborder + height + shift, 200, 20);
        add(propertyCosts);


        JLabel estimatedAppreciation = new JLabel("Estimated Appreciation:");
        estimatedAppreciation.setBounds(xborder, yborder + (2 * height) + shift, 200, 20);
        add(estimatedAppreciation);


        JLabel rentalIncome = new JLabel("Rental Income:");
        rentalIncome.setBounds(xborder, yborder + (3 * height) + shift, 200, 20);
        add(rentalIncome);

        realEstateDisplayHelper();
    }

    private void realEstateDisplayHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120;

        JTextField valuationText = new JTextField();
        valuationText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(valuationText);

        JTextField propertyCostsText = new JTextField();
        propertyCostsText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(propertyCostsText);

        JTextField estimatedAppreciationText = new JTextField();
        estimatedAppreciationText.setBounds(xborder + width, yborder + (2 * height) + shift, 100, 20);
        add(estimatedAppreciationText);

        JTextField rentalIncomeText = new JTextField();
        rentalIncomeText.setBounds(xborder + width, yborder + (3 * height) + shift, 100, 20);
        add(rentalIncomeText);

        JButton saveProperty = new JButton("Enter Real Estate");
        saveProperty.setBounds(xborder, yborder + (3 * height) + 20 + shift, 200, 20);
        saveProperty.addActionListener(new RealEstateButton(valuationText, propertyCostsText, estimatedAppreciationText,
                rentalIncomeText, finance));
        add(saveProperty);


    }

    //Modifies: Finance.SavingsAccount
    //Effects: populates the screen with UI related to Savings Account
    public void savingsAccountDisplay() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120;


        JLabel balance = new JLabel("Balance:");
        balance.setBounds(xborder, yborder + shift, 200, 20);
        add(balance);

        JTextField balanceText = new JTextField();
        balanceText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(balanceText);

        JLabel interestRate = new JLabel("Interest Rate:");
        interestRate.setBounds(xborder, yborder + height + shift, 200, 20);
        add(interestRate);

        JTextField interestRateText = new JTextField();
        interestRateText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(interestRateText);

        JButton saveSavings = new JButton("Set Savings");
        saveSavings.setBounds(xborder, yborder + (3 * height) + 20 + shift, 200, 20);
        saveSavings.addActionListener(new SavingsButton(balanceText, interestRateText, finance));
        add(saveSavings);
    }

    //Modifies: Finance.expenses and Finance.AnnualBudget
    //Effects: populates the left panel with ui related to expenses, allows user to add and remove expenses
    public void expenseBuilder() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120 + 120;


        JLabel expense = new JLabel("Expense Name:");
        expense.setBounds(xborder, yborder + shift, 200, 20);
        add(expense);

        JLabel cost = new JLabel("Monthly Cost:");
        cost.setBounds(xborder, yborder + height + shift, 200, 20);
        add(cost);

        expenseBuilderHelper();
    }

    private void expenseBuilderHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120 + 120;

        JTextField expenseText = new JTextField();
        expenseText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(expenseText);

        JTextField costText = new JTextField();
        costText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(costText);


        JButton saveExpense = new JButton("Add expense");
        saveExpense.setBounds(xborder, yborder + (3 * height) + 20 + shift, 200, 20);
        saveExpense.addActionListener(new ExpenseButton(expenseText, costText, finance));
        add(saveExpense);

        JButton removeExpense = new JButton("Remove expense");
        removeExpense.setBounds(xborder, yborder + (3 * height) + 20 + shift + 25, 200, 20);
        removeExpense.addActionListener(new RemoveExpenseButton(expenseText, costText, finance));
        add(removeExpense);

    }

    //Modifies: Finance.loans and Finance.AnnualBudget
    //Effects: Populates the left pannel with UI that allows the user to add and remove loans
    public void loanBulider() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120 + 120 + 140;


        JLabel loan = new JLabel("Loan tittle:");
        loan.setBounds(xborder, yborder + shift, 200, 20);
        add(loan);

        JLabel outbal = new JLabel("Outstanding Balance:");
        outbal.setBounds(xborder, yborder + height + shift, 200, 20);
        add(outbal);

        JLabel rate = new JLabel("Interest Rate:");
        rate.setBounds(xborder, yborder + (2 * height) + shift, 200, 20);
        add(rate);

        JLabel months = new JLabel("Months to pay Loan:");
        months.setBounds(xborder, yborder + (3 * height) + shift, 200, 20);
        add(months);

        loanBuilderHelper();


    }

    private void loanBuilderHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;
        int shift = 120 + 120 + 120 + 120 + 140;

        JTextField loanText = new JTextField();
        loanText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(loanText);

        JTextField outbalText = new JTextField();
        outbalText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(outbalText);

        JTextField rateText = new JTextField();
        rateText.setBounds(xborder + width, yborder + (2 * height) + shift, 100, 20);
        add(rateText);

        JTextField monthsText = new JTextField();
        monthsText.setBounds(xborder + width, yborder + (3 * height) + shift, 100, 20);
        add(monthsText);

        JButton saveLoan = new JButton("Add Loan");
        saveLoan.setBounds(xborder, yborder + (3 * height) + 20 + shift, 200, 20);
        saveLoan.addActionListener(new LoanButton(loanText, outbalText, rateText, monthsText, finance));
        add(saveLoan);

        loanRemover(loanText, outbalText, rateText, monthsText, finance);
    }

    private void loanRemover(JTextField loanText, JTextField outbalText, JTextField rateText, JTextField monthsText,
                             Finance finance) {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;
        int shift = 120 + 120 + 120 + 120 + 140;

        JButton removeLoan = new JButton("Remove Loan");
        removeLoan.setBounds(xborder, yborder + (3 * height) + 20 + shift + 25, 200, 20);
        removeLoan.addActionListener(new RemoveLoanButton(loanText, outbalText, rateText, monthsText, finance));
        add(removeLoan);
    }

    //Modifies: percentPortfolioInvested and percentRentInvested
    //Effects: populates the left panel with UI that allows the user to set their values.
    public void setPercentInvested() {

        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120 + 120 + 140 + 120 + 25;

        JLabel percPortfolio = new JLabel("Percent Dividends Invested:");
        percPortfolio.setBounds(xborder, yborder + shift, 200, 20);
        add(percPortfolio);

        JTextField percPortfolioText = new JTextField();
        percPortfolioText.setBounds(xborder + width, yborder + shift, width / 2, height);
        add(percPortfolioText);

        JButton portButton = new JButton("Set");
        portButton.setBounds(xborder + width + width / 2, yborder + shift, width / 2, height);
        portButton.addActionListener(new PercentPortfolioInvestedButton(percPortfolioText, this));
        add(portButton);


        setPercentInvestedHelper();
    }

    private void setPercentInvestedHelper() {
        int xborder = 10;
        int yborder = 10;
        int width = 200;
        int height = 20;

        int shift = 120 + 120 + 120 + 120 + 140 + 120 + 25;

        JLabel percRent = new JLabel("Percent Rental Income Invested:");
        percRent.setBounds(xborder, yborder + height + shift, 200, 20);
        add(percRent);

        JTextField percRentText = new JTextField();
        percRentText.setBounds(xborder + width, yborder + height + shift, 100, 20);
        add(percRentText);

        JButton rentButton = new JButton("Set");
        rentButton.setBounds(xborder + width + width / 2, yborder + shift + height, width / 2, height);
        rentButton.addActionListener(new PercentRentInvestedButton(percRentText, this));
        add(rentButton);
    }

    //Effects: provides a save and load buttons that allow users to save and retrieve their data
    public void saveAndLoad() {
        JButton save = new JButton("Save To File");
        save.setBounds(20, 830, 120, 20);
        save.addActionListener(new SaveData(this));
        add(save);
        repaint();

        JButton load = new JButton("Load From File");
        load.setBounds(160, 830, 120, 20);
        load.addActionListener(new LoadData(this));
        add(load);
        repaint();
    }

    //Modifies: this
    //Effects: provides buttons that perform their corresponding functions
    private void displayOperations() {
        int gap = 20;

        JTextField ytext = new JTextField();
        JTextField inflateText = new JTextField();

        JButton saveFunction = new JButton("Future Savings");
        saveFunction.setBounds(1310, 200, 200, 20);
        saveFunction.addActionListener(new SaveFunction(ytext, this));
        add(saveFunction);

        JButton budgetFunction = new JButton("Future Budget");
        budgetFunction.setBounds(1310, 200 + gap, 200, 20);
        budgetFunction.addActionListener(new BudgetFunction(ytext, inflateText, this));
        add(budgetFunction);


        JButton portFunction = new JButton("Future Stock Capital");
        portFunction.setBounds(1310, 200 + gap + gap + gap, 200, 20);
        portFunction.addActionListener(new PortfolioFunction(ytext, this));
        add(portFunction);


        ytext.setBounds(1370, 200 + (4 * gap) + 5, 70, 20);
        add(ytext);

        JLabel inflation = new JLabel("inflation?:");
        inflation.setBounds(1310, 200 + (5 * gap), 70, 20);
        add(inflation);

        inflateText.setBounds(1370, 200 + (5 * gap), 70, 20);
        add(inflateText);

        displayOperationsHelper();
    }

    private void displayOperationsHelper() {
        int gap = 20;
/*
        JButton loanFunction = new JButton("Future Loan status");
        loanFunction.setBounds(1310, 200 + gap + gap, 200, 20);
        //
        add(loanFunction);
*/
        JLabel years = new JLabel("years?:");
        years.setBounds(1310, 200 + (4 * gap) + 5, 100, 20);
        add(years);

    }


    AnnualBudget copy;

    //Modifies: this
    //Effects: responsible for drawing graphs and providing a financial summary as well as the design
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        design(g);
        summaryPanel(g);
        drawAxis(g);

        if (isSaveFunctionBool()) {
            Double answer = saveFunctionAnswer;
            g.drawString(answer.toString(), 1410, 400);
            drawBarGraphs(g, saveFunctionAnswer, finance.getSavings().getBalance());
        } else if (isBudgetFunctionBool()) {
            Double answer = getBudgetFunctionAnswer();
            copy = new AnnualBudget(createCopyExpenses(finance.getExpenses()),
                    createCopyLoans(finance.getLoans()));
            g.drawString(answer.toString(), 1410, 400);
            drawBarGraphs(g, budgetFunctionAnswer, copy.totalAnnualBudget());
        } else if (isPortfolioFunctionBool()) {
            Double answer = getPortfolioFunctionAnswer();
            g.drawString(answer.toString(), 1410, 400);
            drawBarGraphs(g, portfolioFunctionAnswer, finance.getPortfolio().getCapital());
        }


    }

    private void drawAxis(Graphics g) {
        g.drawLine(400, 700, 400 + 800, 700);
        g.drawLine(400, 700, 400, 100);


    }

    // draws a bar graph contrasting initial and final states
    private void drawBarGraphs(Graphics g, double fnAnswer, double initialAmount) {
        int x0 = 400;
        int y0 = 700;

        while (fnAnswer >= 600 && initialAmount >= 600) {
            fnAnswer = fnAnswer / 2;
            initialAmount = initialAmount / 2;
        }
        g.setColor(Color.red);
        g.fillRect(450, 700 - (int) initialAmount, 100, (int) initialAmount);
        g.fillRect(600, 700 - (int) fnAnswer, 100, (int) fnAnswer);


    }

//helpers   helpers helpers helpers helpers helpers helpers helpers helper helpers helpers


    private void design(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, 310, 900);
        g.fillRect(1290, 0, 310, 900);
    }

    //Creates a side pannel that sumerizes financial data
    private void summaryPanel(Graphics g) {
        g.setColor(Color.BLACK);

        g.drawString("Financial Summary:", 1300, 20);

        g.drawString("Net Salary:", 1310, 40);
        Double salary = finance.getSalary().calculateNetIncome();
        g.drawString(salary.toString(), 1400, 40);
        repaint();

        g.drawString("Capital:", 1310, 40 + 20);
        Double capital = finance.getPortfolio().getCapital();
        Double roi = finance.getPortfolio().getEstimatedRoi() * 100;
        g.drawString(capital.toString() + " @ " + roi + " % return", 1400, 40 + 20);
        repaint();

        g.drawString("Rental Income:", 1310, 40 + 20 + 20);
        Double income = finance.getProperty().netAnnualRentalIncome();
        g.drawString(income.toString(), 1400, 40 + 20 + 20);
        repaint();

        g.drawString("Savings:", 1310, 40 + 60);
        Double savings = finance.getSavings().getBalance();
        Double rate = finance.getSavings().getInterestRate() * 100;
        g.drawString(savings.toString() + " @ " + rate + " % return", 1400, 40 + 60);
        repaint();

        summaryPanelHelper(g);
    }

    Double totalBudget;

    private void summaryPanelHelper(Graphics g) {
        g.drawString("Annual Budget:", 1300, 40 + 100);
        totalBudget = 0.0;
        for (Loan l : finance.getLoans()) {
            totalBudget = totalBudget + (l.getOutstandingBalance() / l.getMonthsToPayLoan()) * 12;
        }
        for (Expense expense : finance.getExpenses()) {
            totalBudget = totalBudget + (12 * expense.getCost());
        }
        g.drawString("" + totalBudget, 1400, 40 + 100);
        repaint();
        g.drawString("Annual budget Breakdown:", 1300, 480);
        int y = 500;
        for (Expense expense : finance.getExpenses()) {
            g.drawString(expense.getExpense() + " - " + expense.getCost(), 1300, y);
            y = y + 20;
        }
        int x = 500;
        for (Loan loan : finance.getLoans()) {
            g.drawString(loan.getLoan() + " - " + (loan.getOutstandingBalance()), 1400, x);
            x = x + 20;
        }


    }


    public double getPercentRentalIncomeInvested() {
        return percentRentalIncomeInvested;
    }

    public void setPercentRentalIncomeInvested(double percentRentalIncomeInvested) {
        this.percentRentalIncomeInvested = percentRentalIncomeInvested;
    }

    public double getPercentPortfolioInvested() {
        return percentPortfolioInvested;
    }

    public void setPercentPortfolioInvested(Double percentPortfolioInvested) {
        this.percentPortfolioInvested = percentPortfolioInvested;
    }

    public void setPercentPortfolioInvested(double percentPortfolioInvested) {
        this.percentPortfolioInvested = percentPortfolioInvested;
    }

    public double getSaveFunctionAnswer() {
        return saveFunctionAnswer;
    }

    public void setSaveFunctionAnswer(double saveFunctionAnswer) {
        this.saveFunctionAnswer = saveFunctionAnswer;
    }

    public Finance getFinance() {
        return finance;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public double getPortfolioFunctionAnswer() {
        return portfolioFunctionAnswer;
    }

    public void setPortfolioFunctionAnswer(double portfolioFunctionAnswer) {
        this.portfolioFunctionAnswer = portfolioFunctionAnswer;
    }

    public boolean isPortfolioFunctionBool() {
        return portfolioFunctionBool;
    }

    public void setPortfolioFunctionBool(boolean portfolioFunctionBool) {
        this.portfolioFunctionBool = portfolioFunctionBool;
    }

    public boolean isSaveFunctionBool() {
        return saveFunctionBool;
    }

    public void setSaveFunctionBool(boolean saveFunctionBool) {
        this.saveFunctionBool = saveFunctionBool;
    }

    public double getBudgetFunctionAnswer() {
        return budgetFunctionAnswer;
    }

    public void setBudgetFunctionAnswer(double budgetFunctionAnswer) {
        this.budgetFunctionAnswer = budgetFunctionAnswer;
    }

    public boolean isBudgetFunctionBool() {
        return budgetFunctionBool;
    }

    public void setBudgetFunctionBool(boolean budgetFunctionBool) {
        this.budgetFunctionBool = budgetFunctionBool;
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


}
