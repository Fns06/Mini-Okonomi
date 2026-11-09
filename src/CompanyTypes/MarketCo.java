package src.CompanyTypes;

import src.AbstractClasses.Company;

public class MarketCo extends Company {

    public MarketCo(String name, int employees, int stocks) {
        super(name, employees, stocks);
    }

    public MarketCo(String name, int employees, double money, int stocks) {
        super(name, employees, money, stocks);
    }
}