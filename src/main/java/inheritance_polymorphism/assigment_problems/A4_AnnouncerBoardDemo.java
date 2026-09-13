package inheritance_polymorphism.assigment_problems;

// Demonstration of polymorphic race announcement formatting and safe downcasting to relay teams.
public class A4_AnnouncerBoardDemo {
    public static void main(String[] args) {
        RunnerEntry runnerEntry = new RunnerEntry("BIB2001", 80, "Open 10K");
        runnerEntry.pay(30);
        runnerEntry.applyLateFee(20);

        RelayTeamEntry relayEntry = new RelayTeamEntry("BIB4001", 300, 4);

        RaceEntry[] fleet = {runnerEntry, relayEntry};
        System.out.println(RaceEntry.announceAll(fleet));

        try {
            RaceEntry plain = new RaceEntry("BIB5001", 50);
            RelayTeamEntry bad = (RelayTeamEntry) plain;
            System.out.println(bad.getTeamSize());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught as expected: " + e.getMessage());
        }
    }
}
