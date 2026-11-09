package src.CompanyTypes;

import src.AbstractClasses.Company;

public class RessorceCo extends Company {
    private int ressorces;
    private int monthlyProductionPerEmployee;

    public RessorceCo(String name, int employees, int stocks, double sharePrice, double percentPayment, double taxPercent,
                      int ressorces, int monthlyProductionPerEmployee) {
        this(name, employees, 0.0, stocks, sharePrice, percentPayment, taxPercent,
             ressorces, monthlyProductionPerEmployee);
    }

    public RessorceCo(String name, int employeesCount, double cash, int stocks, double sharePrice,
                      double percentPayment, double taxPercent, int ressorces, int monthlyProductionPerEmployee) {
        if (ressorces < 0 || monthlyProductionPerEmployee < 0) {
            throw new IllegalArgumentException("Illegal value in a variable");
        }
        super(name, employeesCount, cash, stocks, sharePrice, percentPayment, taxPercent);
        this.ressorces = ressorces;
        this.monthlyProductionPerEmployee = monthlyProductionPerEmployee;
    }

    // Getter
    public int getRessorces() {
        return ressorces;
    }

    public int getMonthlyProductionPerEmployee(){
        return monthlyProductionPerEmployee;
    }

    // Setter
    public void setRessorces(int ressorces) {
        this.ressorces = ressorces;
    }

    public void getMonthlyProductionPerEmployee(int monthlyProductionPerEmployee){
        this.monthlyProductionPerEmployee = monthlyProductionPerEmployee;
    }

    @Override
    public String toString() {
        return "RessorceCo [" + super.toString() + String.format(
                ", Resources: %d, Monthly production per employee: %d]",
                ressorces, monthlyProductionPerEmployee);
    }
}