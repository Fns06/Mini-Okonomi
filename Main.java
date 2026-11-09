import src.CountryTypes.Democracy;
import src.CountryTypes.Communism;
import src.CountryTypes.SmalerClasses.COFOG;
import src.CountryTypes.SmalerClasses.Party;

import java.util.EnumMap;
import java.util.Map;

public class Main {
    private Democracy norway;
    private Communism mandoria;
    private Map<COFOG, Double> starter;

    private static final String BOLD = "\u001B[1m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Main main = new Main();
        main.settup();
        main.run(2);
    }

    public void run(int months){
        for(int i = 0; i < months; i++){
            if (i == 0) {
                System.out.println(BOLD + "Starting stats:" + RESET);
            }
            else{
                System.out.println(BOLD + "\nMonth number " + i + RESET);
            }
            
            System.out.println("---------------------------------------");
            System.out.println(norway + "\n");
            //norway.addMoney(1000000);

            System.out.println("---------------------------------------");
            System.out.println(mandoria + "\n");
        }
    }

    public void settup() {
        Party[] partyList1 = getPartyList1();

        //The democracy of Norway
        norway = new Democracy("Norway", 5000, 200000, 0.30, starter, 100, partyList1);

        mandoria = new Communism("Mandoria",7000, 400000, 0.40, starter);
    }

    public void holeBugetUsed(Map<COFOG, Double> budget){
        double sum = 0;
        for(double procent : budget.values()){
            sum += procent;
        }
        if (Math.abs(sum - 100) > 0.0001) {
            throw new IllegalArgumentException("All the buget is not used");
        }
    }

    public Party[] getPartyList1(){
        //Starter budgets
        starter = new EnumMap<>(COFOG.class);
        starter.put(COFOG.HEALTH, 20.0);
        starter.put(COFOG.DEFENCE, 20.0);
        starter.put(COFOG.EDUCATION, 20.0);
        starter.put(COFOG.MAINTENANCE, 20.0);
        starter.put(COFOG.PUBLIC_ORDER_AND_SAFETY, 20.0);
        holeBugetUsed(starter);


        //Some wanted budgets for parties
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
        return partyList;
    }
}