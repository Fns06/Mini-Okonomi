package src.AbstractClasses;

import java.util.Map;

import src.CountryTypes.SmalerClasses.COFOG;

public abstract class Country {
    private String name;
    private int residents;
    private double fund;
    private double taxPercent;
    private Map<COFOG, Double> budget;

    public Country(String name, int residents, double taxPercent, Map<COFOG, Double> budget) {
        this(name, residents, 0.0, taxPercent, budget);
    }

    public Country(String name, int residents, double fund, double taxPercent, Map<COFOG, Double> budget) {
        this.name = name;
        this.residents = residents;
        this.fund = fund;
        this.taxPercent = taxPercent;
        this.budget = budget;
    }

    // Helping methods
    public void addMoney(double money){
        this.fund += money;
    }

    public void subtractMoney(double money){
        this.fund -= money;
    }

    public double moneyPerPerson(){
        return fund / residents;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getResidents() {
        return residents;
    }

    public double getFund() {
        return fund;
    }
    
    public double getTaxPercent(){
        return taxPercent;
    }

    public Map<COFOG, Double> getBudget(){
        return budget;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setResidents(int residents) {
        this.residents = residents;
    }

    public void setFund(double fund) {
        this.fund = fund;
    }

    public void setTaxPercent(double taxPercent){
        this.taxPercent = taxPercent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(": ").append(name)
          .append("\nResidents = ").append(residents)
          .append("\nFund = ").append(String.format("%.2f", fund))
          .append("\nTaxPercent = ").append(String.format("%.2f", taxPercent))
          .append("\nBudget:");

        for (Map.Entry<COFOG, Double> entry : budget.entrySet()) {
            sb.append(String.format("\n  %s: %.2f %%", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}