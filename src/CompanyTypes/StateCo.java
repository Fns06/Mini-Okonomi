package src.CompanyTypes;

import src.AbstractClasses.Company;

public class StateCo extends Company {

    public StateCo(String name, int employees, int stocks) {
        super(name, employees, stocks);
    }

    public StateCo(String name, int employees, double money, int stocks) {
        super(name, employees, money, stocks);
    }
}