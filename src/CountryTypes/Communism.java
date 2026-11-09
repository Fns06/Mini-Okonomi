package src.CountryTypes;
import java.util.Map;

import src.AbstractClasses.Country;
import src.CountryTypes.SmalerClasses.COFOG;

public class Communism extends Country{
    
    public Communism(String name, int residents, Map<COFOG, Double> budget) {
        super(name, residents, budget);
    }

    public Communism(String name, int residents, double fund, Map<COFOG, Double> budget) {
        super(name, residents, fund, budget);
    }

    public void calculateYearlyBudget(){
        //TODO calculateYearlyBudget
        // Should use values from real data
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Democracy: ").append(getName())
        .append("\nresidents = ").append(getResidents())
        .append("\nfund = ").append(getFund())
        .append("\nbudget:");

        for (Map.Entry<COFOG, Double> entry : getBudget().entrySet()) {
            sb.append("\n  ").append(entry.getKey()).append(": ").append(entry.getValue()).append(" %");
        }
        return sb.toString();
    }
}
