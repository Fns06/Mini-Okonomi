package src.AbstractClasses;

public abstract class Company {
    private String name;
    private int employees;
    private double money;
    private double salaryMTH;
    private double value;
    private int stocks;
    private double percentRisk;

    public Company(String name, int employees, int stocks, double percentRisk) {
        this.name = name;
        this.employees = employees;
        this.money = 0.0;
        this.stocks = stocks;
        setPercentRisk(percentRisk);
        this.salaryMTH = calculateSalaryMTH();
        this.value = calculateValue();
    }

    public Company(String name, int employees, double money, int stocks, double percentRisk) {
        this.name = name;
        this.employees = employees;
        this.money = money;
        this.stocks = stocks;
        setPercentRisk(percentRisk);
        this.salaryMTH = calculateSalaryMTH();
        this.value = calculateValue();
    }

    // Helping methods
    public void addMoney(double money) {
        this.money += money;
    }

    public void subtractMoney(double money) {
        this.money -= money;
    }

    public double getValuePerStock() {
        return value / stocks;
    }

    public boolean canCoverPayrollMTH(int months) {
        return money >= salaryMTH * employees * months;
    }

    public boolean canCoverPayrollYear(int years) {
        return money >= salaryMTH * employees * years * 12;
    }

    public int MTHsPayrollCanBePayed() {
        return (int) (money / (salaryMTH * employees));
    }

    @Override
    public String toString() {
        return String.format(
            "Name: %s, Employees: %d, Monthly salary: %.2f, Money: %.2f, Value: %.2f, Stocks: %d",
            name, employees, salaryMTH, money, value, stocks);
    }

    // Calculators
    public double calculateSalaryMTH() {
        return 0; // TODO
    }

    public double calculateValue() {
        return 0; // TODO
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getEmployees() {
        return employees;
    }

    public double getSalaryMTH() {
        return salaryMTH;
    }

    public double getMoney() {
        return money;
    }

    public double getValue() {
        return value;
    }

    public int getStocks() {
        return stocks;
    }

    public double getPercentRisk() {
        return percentRisk;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public void setSalaryMTH(double salaryMTH) {
        this.salaryMTH = salaryMTH;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public void setPercentRisk(double percentRisk) {
        if (percentRisk < 0 || percentRisk > 100) {
            throw new IllegalArgumentException("Percentage risk must be between 0 and 100");
        }
        this.percentRisk = percentRisk;
    }
}