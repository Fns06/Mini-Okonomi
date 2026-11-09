package src.CountryTypes.SmalerClasses;

public class Parliament {
    private int parlamentSeats;
    private Party[] parties;

    public Parliament(int parlamentSeats, Party[] parties) {
        this.parlamentSeats = parlamentSeats;
        this.parties = parties;
    }

    // methods
    public void doElection() {
        // TODO doElection - Temp exists
        // We need citizens to feel more motivated to vote for one party over another.

        // temp, all parties get the same amount of parlament seats
        int tempPartySeats = parlamentSeats / parties.length;
        for (Party p : parties) {
            p.setParlamentSeats(tempPartySeats);
        }
        // Gives the leftover seats to the first party
        if (tempPartySeats * parties.length != parlamentSeats) {
            int leftoverseats = parlamentSeats - tempPartySeats;
            parties[0].setParlamentSeats(tempPartySeats + leftoverseats);
        }
        //lastly we need to run somthing like main.holeBugetUsed() so all of the seats is used
    }

    // geters
    public int getParlamentSeats() {
        return parlamentSeats;
    }

    public Party[] getParties(){
        return parties;
    }

    public Party getParty(String name) {
        for (Party p : parties) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No party has that name");
    }

    public String[] getAllPartyNames() {
        String[] tempParties = new String[getNumberOfParties()];
        for (int i = 0; i < getNumberOfParties(); i++) {
            tempParties[i] = parties[i].getName();
        }
        return tempParties;
    }

    // seters
    public void setParlamentSeats(int parlamentSeats) {
        if (parlamentSeats <= 0) {
            throw new IllegalArgumentException("Antall seter må være større enn 0");
        }
        this.parlamentSeats = parlamentSeats;
    }

    // Hepler methods
    public void add(Party party) {
        boolean innList = false;
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] == null) {
                parties[i] = party;
                innList = true;
                break;
            }
        }
        if (!innList) {
            Party[] tempParties = parties;
            parties = new Party[Math.max(1, tempParties.length * 2)];
            for (int i = 0; i < tempParties.length; i++) {
                parties[i] = tempParties[i];
            }
            parties[tempParties.length] = party;
        }
    }

    public void delete(String name) {
        boolean found = false;
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != null && parties[i].getName().equals(name)) {
                found = true;
            }
            if (found && i != parties.length - 1) {
                parties[i] = parties[i + 1];
            }
            if (found && i == parties.length - 1) {
                parties[i] = null;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("The named party is not in the list");
        }
    }

    public int getNumberOfParties() {
        int n = 0;
        for (Party p : parties) {
            if (p != null) {
                n++;
            }
            if (p == null) {
                return n;
            }
        }
        return -1;
    }
}