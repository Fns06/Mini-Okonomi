package src.CompanyTypes;

import src.AbstractClasses.Company;

public class StateCo extends Company {

    public StateCo(String name, int employees, int stocks, double sharePrice, double percentPayment, double taxPercent) {
        this(name, employees, 0.0, stocks, sharePrice, percentPayment, taxPercent);
    }

    public StateCo(String name, int employees, double cash, int stocks, double sharePrice, double percentPayment, double taxPercent) {
        super(name, employees, cash, stocks, sharePrice, percentPayment, taxPercent);
    }

    @Override
    public String toString() {
        return "StateCo [" + super.toString() + "]";
    }
}