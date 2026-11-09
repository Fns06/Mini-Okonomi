package src.CountryTypes;
import java.util.Map;

import src.AbstractClasses.Country;
import src.CountryTypes.SmalerClasses.COFOG;

public class Communism extends Country{
    
    public Communism(String name, int residents, double taxPercent, Map<COFOG, Double> budget) {
        super(name, residents, taxPercent, budget);
    }

    public Communism(String name, int residents, double fund, double taxPercent, Map<COFOG, Double> budget) {
        super(name, residents, fund, taxPercent, budget);
    }

    public void calculateYearlyBudget(){
        //TODO calculateYearlyBudget
        // Should use values from real data
    }

        @Override
    public String toString() {
        return super.toString();
    }
}
