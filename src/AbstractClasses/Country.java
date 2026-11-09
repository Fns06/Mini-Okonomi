package src.AbstractClasses;

import java.util.Map;

import src.CountryTypes.SmalerClasses.COFOG;

public abstract class Country {
    private String name;
    private int residents;
    private double fund;
    private Map<COFOG, Double> budget;

    public Country(String name, int residents, Map<COFOG, Double> budget) {
        this.name = name;
        this.residents = residents;
        this.fund = 0;
        this.budget = budget;
    }

    public Country(String name, int residents, double fund, Map<COFOG, Double> budget) {
        this.name = name;
        this.residents = residents;
        this.fund = fund;
        this.budget = budget;
    }

    // Concrete methods
    public void addMoney(double money){
        this.fund += money;
    }

    public void subtractMoney(double money){
        this.fund -= money;
    }

    public double moneyPerPerson(){
        return fund / residents;
    }

    //Abstract methods
    public abstract String toString();

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
}