package src.CompanyTypes;

import src.AbstractClasses.Company;

public class RessorceCo extends Company {
    private int ressorces;
    private int monthlyProductionPerEmployee;

    public RessorceCo(String name, int employees, int stocks, int ressorces, int monthlyProductionPerEmployee) {
        super(name, employees, stocks);
        this.ressorces = ressorces;
        this.monthlyProductionPerEmployee = monthlyProductionPerEmployee;
    }

    public RessorceCo(String name, int employees, double money, int stocks, int ressorces, int monthlyProductionPerEmployee) {
        super(name, employees, money, stocks);
        this.ressorces = ressorces;
        this.monthlyProductionPerEmployee = monthlyProductionPerEmployee;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                ", Resources: %d, Monthly production per employee: %d",
                ressorces, monthlyProductionPerEmployee);
    }
}