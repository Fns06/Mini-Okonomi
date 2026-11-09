import src.CountryTypes.Democracy;
import src.CountryTypes.Communism;
import src.CountryTypes.SmalerClasses.COFOG;
import src.CountryTypes.SmalerClasses.Party;

import java.util.EnumMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //Starter budgets
        Map<COFOG, Double> starter = new EnumMap<>(COFOG.class);
        starter.put(COFOG.HEALTH, 20.0);
        starter.put(COFOG.DEFENCE, 20.0);
        starter.put(COFOG.EDUCATION, 20.0);
        starter.put(COFOG.MAINTENANCE, 20.0);
        starter.put(COFOG.PUBLIC_ORDER_AND_SAFETY, 20.0);
        holeBugetUsed(starter);

        //Some wanted budgets for some parties
        Map<COFOG, Double> browns = new EnumMap<>(COFOG.class);
        browns.put(COFOG.HEALTH, 20.0);
        browns.put(COFOG.DEFENCE, 20.0);
        browns.put(COFOG.EDUCATION, 20.0);
        browns.put(COFOG.MAINTENANCE, 20.0);
        browns.put(COFOG.PUBLIC_ORDER_AND_SAFETY, 20.0);
        holeBugetUsed(browns);

        Map<COFOG, Double> reds = new EnumMap<>(COFOG.class);
        reds.put(COFOG.HEALTH, 10.0);
        reds.put(COFOG.DEFENCE, 40.0);
        reds.put(COFOG.EDUCATION, 10.0);
        reds.put(COFOG.MAINTENANCE, 10.0);
        reds.put(COFOG.PUBLIC_ORDER_AND_SAFETY, 30.0);
        holeBugetUsed(reds);

        Map<COFOG, Double> blues = new EnumMap<>(COFOG.class);
        blues.put(COFOG.HEALTH, 30.0);
        blues.put(COFOG.DEFENCE, 0.0);
        blues.put(COFOG.EDUCATION, 30.0);
        blues.put(COFOG.MAINTENANCE, 20.0);
        blues.put(COFOG.PUBLIC_ORDER_AND_SAFETY, 20.0);
        holeBugetUsed(blues);

        //The list over all parties in one contry
        Party[] partyList = {
            new Party("Browns", browns),
            new Party("Reds", reds),
            new Party("Blues", blues)
        };

        //The democracy of Norway
        Democracy norway = new Democracy("Norway", 5000, 200000, starter, 100, partyList);

        Communism mandoria = new Communism("Mandoria",7000, 400000, starter);


    }

    public static void holeBugetUsed(Map<COFOG, Double> budget){
        double sum = 0;
        for(double procent : budget.values()){
            sum += procent;
        }
        if (Math.abs(sum - 100) > 0.0001) {
            throw new IllegalArgumentException("All the buget is not used");
        }
    }
}