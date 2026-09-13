package inheritance_polymorphism.assigment_problems;

// Demonstration of static bib counter, discount code validation, and null-tolerant nightly settlement.
public class A5_SettlementEngineDemo {
    public static void main(String[] args) {
        System.out.println("isValidDiscountCode(\"M123A\"): " + RaceEntry.isValidDiscountCode("M123A"));
        System.out.println("isValidDiscountCode(\"M12A\"): " + RaceEntry.isValidDiscountCode("M12A"));
        System.out.println("isValidDiscountCode(\"X123A\"): " + RaceEntry.isValidDiscountCode("X123A"));

        EliteRunnerEntry eliteEntry = new EliteRunnerEntry("BIB3001", 150, "Elite Full Marathon", 500);
        RelayTeamEntry relayEntry = new RelayTeamEntry("BIB4001", 300, 4);

        eliteEntry.pay(10, "UPI");

        RaceEntry[] batch = {eliteEntry, null, relayEntry};
        System.out.println(RaceEntry.settleNight(batch));

        System.out.println("Bib Counter: " + RaceEntry.getBibCounter());
    }
}
