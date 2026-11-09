package src.CountryTypes.SmalerClasses;

import java.util.Map;

public class Party {
    private final String name;
    private int parlamentSeats;
    private Map<COFOG, Double> wantedBudget;

    public Party(String name, Map<COFOG, Double> wantedBudget) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The party needs a name");
        }
        this.name = name;
        this.wantedBudget = wantedBudget;
        //No seats before election
        parlamentSeats = 0;
    }

    //geters
    public String getName() {
        return name;
    }

    public int getParlamentSeats() {
        return parlamentSeats;
    }

    public Map<COFOG, Double> getWantedBudget(){
        return wantedBudget;
    }

    //seters
    public void setParlamentSeats(int parlamentSeats) {
        if (parlamentSeats < 0) {
            throw new IllegalArgumentException("Antall seter kan ikke være negativt");
        }
        this.parlamentSeats = parlamentSeats;
    }

}
