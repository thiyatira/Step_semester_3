package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 5: Nightly Fleet Reconciliation Demo
 */
public class P5_FleetReconciliationDemo {

    public static void main(String[] args) {
        BusTicketAccount[] accounts = {
            new SleeperCoachAccount("BK001", 2000),
            null,
            new BusTicketAccount("BK002", 1200)
        };
        double[] amounts = {1200, 900, 700};
        int[] minutesLateArray = {10, 5, 0};

        System.out.println("=== Nightly Fleet Reconciliation Batch Processing ===");
        NightlyFleetReconciliation.processBatch(accounts, amounts, minutesLateArray);

        System.out.println("\n=== Individual Account Processing ===");
        NightlyFleetReconciliation engine = new NightlyFleetReconciliation();
        for (int i = 0; i < accounts.length; i++) {
            engine.processAccount(accounts[i], amounts[i], minutesLateArray[i]);
        }
    }
}
