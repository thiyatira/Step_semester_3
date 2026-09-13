package inheritance_polymorphism.assigment_problems;

// Demonstration of runner hierarchy, multilevel inheritance, and polymorphic balance totaling.
public class A2_RaceFamilyDemo {
    public static void main(String[] args) {
        RunnerEntry runnerEntry = new RunnerEntry("BIB2001", 80, "Open 10K");
        EliteRunnerEntry eliteEntry = new EliteRunnerEntry("BIB3001", 150, "Elite Full Marathon", 500);
        RelayTeamEntry relayEntry = new RelayTeamEntry("BIB4001", 300, 4);

        System.out.println(runnerEntry.announce());
        System.out.println(eliteEntry.announce());
        System.out.println(relayEntry.announce());

        System.out.println(RaceEntry.classifyGeneration(eliteEntry));
        System.out.println(RaceEntry.classifyGeneration(relayEntry));

        RaceEntry[] entries = {runnerEntry, eliteEntry, relayEntry};
        System.out.println("Total Balance Due: " + RaceEntry.getTotalBalanceDue(entries));
    }
}
