# Financial Planner

## a financial planner that helps you reach your financials goals and prepare for the worst

This application will be built to provide a representation of a user's financial situation. Allowing the user to 
keep track of all their money and its growth across various accounts and investments.
The user will be able to change their finances and determine the effect it will have on their financial goal. The 
application will be able to determine whether their current financial strategy can meet their goals, and make changes 
otherwise.

It will model things like a user's:

- Savings
- Investments
- Job income
- cost of living
- existing loans
- investment income


It will be able to determine where income earned is spent according to the user's specifications.
 
##User stories:

- As a user I want to be able to:

- Create a summary of my  expenses (groceries, loan payments,tuition, gas, rent, discretionary spending etc.)
- Set % of my net job income to Invest/save
- add investments with expected ROI
- Set % of my investment income to re-invest/save

the application will use the data mentioned above to determine:


- Determine balance on a savings account with fixed interest x years from now
- Determine value of investment portfolio x years from now
- Determine status of loans x years from now
- Determine annual budget x years from now
- how long will it take to have x amount of money saved up in a savings account
- How will my financial situation look like 10 years from now(net worth, income, loans etc)

- As a user, I want to be able to save my financial information to file
- As a user, I want to be able to be able to load my financial information from file




- Phase 4 task 2:  Type hierarchy
    -               abstract class/supertype -> Function
                    subtypes -> SaveFunction(estimates salary)
                             -> BudgetFunction
                             -> PortfolioFunction
                             
- Phase 4 task 3:  
   -   - remove the association from Finance to Loan and Expenses
       - try to remove the association from Function to Finance
       - Make GUI maintain a list of all buttons by creating a Button Class
         that is a supertype of all classes ending in "button"
