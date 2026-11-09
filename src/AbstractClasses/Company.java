package src.AbstractClasses;

public abstract class Company {
    private String name;
    private int employeesCount;
    private double cash;
    private double revenueYear;
    private double monthlySalary;
    private int stocks; // Later
    private double sharePrice; // Later
    private double paymentPercent;
    private double taxPercent;

    public Company(String name, int employeesCount, double cash, int stocks, double sharePrice, double paymentPercent,
            double taxPercent) {
        if (name == null || employeesCount <= 0 || cash < 0 || stocks <= 0 || sharePrice < 0
                || (paymentPercent < 0 || paymentPercent > 1) || (taxPercent < 0 || taxPercent > 1)) {
            throw new IllegalArgumentException("Illegal value in a variable");
        }
        this.name = name;
        this.employeesCount = employeesCount;
        this.cash = cash;
        this.monthlySalary = calculatemonthlySalary();
        this.stocks = stocks;
        this.sharePrice = sharePrice;
        this.paymentPercent = paymentPercent;
        this.taxPercent = taxPercent;
    }

    // Helping methods
    public void addMoney(double cash) {
        this.cash += cash;
    }

    public void subtractMoney(double cash) {
        this.cash -= cash;
    }

    public double getMarketValue() {
        return stocks * sharePrice;
    }

    public boolean canCoverPayrollMTH(int months) {
        return cash >= monthlySalary * employeesCount * months;
    }

    public boolean canCoverPayrollYear(int years) {
        return cash >= monthlySalary * employeesCount * years * 12;
    }

    public int MTHsPayrollCanBePayed() {
        return (int) (cash / (monthlySalary * employeesCount));
    }

    public boolean positiveRevenue() {
        if (paymentPercent + taxPercent < 1) {
            return true;
        }
        return false;
    }

    // Calculators
    public double calculatemonthlySalary() {
        return (revenueYear * paymentPercent / employeesCount) / 12;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getEmployees() {
        return employeesCount;
    }

    public double getmonthlySalary() {
        return monthlySalary;
    }

    public double getMoney() {
        return cash;
    }

    public int getStocks() {
        return stocks;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public double getPaymentPercent() {
        return paymentPercent;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public void setmonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setMoney(double cash) {
        this.cash = cash;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public void setPaymentPercent(double paymentPercent) {
        this.paymentPercent = paymentPercent;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Employees: %d, Monthly salary: %.2f, Money: %.2f, Stocks: %d, Share price: %.2f",
                name, employeesCount, monthlySalary, cash, stocks, sharePrice);
    }
}