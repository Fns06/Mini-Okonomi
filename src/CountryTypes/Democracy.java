package src.CountryTypes;

import java.util.Map;

import src.AbstractClasses.Country;
import src.CountryTypes.SmalerClasses.COFOG;
import src.CountryTypes.SmalerClasses.Parliament;
import src.CountryTypes.SmalerClasses.Party;

public class Democracy extends Country {
    private Parliament parliament;

    public Democracy(String name, int residents, double taxPercent, Map<COFOG, Double> budget, int parlamentSeats, Party[] parties) {
        super(name, residents, taxPercent, budget);
        parliament = new Parliament(parlamentSeats, parties);
    }

    public Democracy(String name, int residents, double fund, double taxPercent, Map<COFOG, Double> budget, int parlamentSeats,
            Party[] parties) {
        super(name, residents, fund, taxPercent, budget);
        parliament = new Parliament(parlamentSeats, parties);
    }

    public void calculateYearlyBudget() {
        // Gets the current budget
        Map<COFOG, Double> budget = super.getBudget();

        // Sets new values for all COFOG's
        for (int i = 0; i < COFOG.values().length; i++) {
            Double value = 0.0;
            // Variable for checking if all parlament seats are counted
            int parlamentSeatsCheck = 0;

            // Finds the avrage value for all parties where each party gets one "influence"
            // per parliament seat they hold devided by parliament seats
            for (Party p : parliament.getParties()) {
                value += p.getParlamentSeats() * p.getWantedBudget().get(COFOG.values()[i]);
                parlamentSeatsCheck += p.getParlamentSeats();
            }
            value /= parliament.getParlamentSeats();

            // Checks if all parliament seat have been counted
            if (parlamentSeatsCheck != parliament.getParlamentSeats()) {
                throw new IllegalStateException("The number og parlament seats(" + parliament.getParlamentSeats()
                        + ") is not equal to: " + parlamentSeatsCheck);
            }
            // Sets the new value to the current budget
            budget.put(COFOG.values()[i], value);
        }
    }

    // geters
    public Parliament getParliament() {
        return parliament;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nParliament: ");

        for(Party p : parliament.getParties()){
            sb.append(String.format("\n  %s: %s", "Party " + p.getName(), "Parliament seats: " + p.getParlamentSeats()));
        }
        return super.toString() + sb;
    }
}
