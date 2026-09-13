package inheritance_polymorphism.assigment_problems;

// RelayTeamEntry extends RaceEntry hierarchically for team-based race registrations.
public class RelayTeamEntry extends RaceEntry {
    private int teamSize;

    public RelayTeamEntry(String bibNumber, double entryFee, int teamSize) {
        super(bibNumber, entryFee);
        if (teamSize <= 0) {
            throw new IllegalArgumentException("Team size must be positive.");
        }
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    @Override
    public String announce() {
        return "Relay Team | Bib: " + bibNumber + " | Team Size: " + teamSize + " | Balance: " + balanceDue;
    }
}
