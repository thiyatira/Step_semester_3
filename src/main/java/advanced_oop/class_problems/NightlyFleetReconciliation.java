package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 5: Nightly Fleet Reconciliation Engine
 * Safely reconciles batches containing regular accounts, sleeper accounts, and null values.
 */
public class NightlyFleetReconciliation {

    public void processAccount(BusTicketAccount account, double amount, int minutesLate) {
        if (account == null) {
            System.out.println("Skipped null account entry.");
            return;
        }
        double penalty = account.calculatePenalty(minutesLate);
        String type = (account instanceof SleeperCoachAccount) ? "Sleeper" : "Regular";
        System.out.printf("Processed %s Account %s | Settled: Rs %.2f | Penalty: Rs %.2f%n",
                type, account.getBookingId(), amount, penalty);
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        if (accounts == null) {
            System.out.println("No accounts provided for reconciliation.");
            return;
        }

        int processed = 0;
        int nullSkipped = 0;
        int sleeperCount = 0;
        int regularCount = 0;
        double grandTotalPenalties = 0.0;

        for (int i = 0; i < accounts.length; i++) {
            BusTicketAccount acc = accounts[i];
            if (acc == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            int minsLate = (minutesLateArray != null && i < minutesLateArray.length) ? minutesLateArray[i] : 0;
            double penalty = acc.calculatePenalty(minsLate);

            if (acc instanceof SleeperCoachAccount) {
                sleeperCount++;
                // Sleeper coach penalty policy: flat 10% premium on late penalties
                penalty = penalty * 1.10;
            } else {
                regularCount++;
            }

            grandTotalPenalties += penalty;
        }

        System.out.printf("%d processed | %d null skipped | %d sleeper | %d regular | grand total penalties = Rs %.2f%n",
                processed, nullSkipped, sleeperCount, regularCount, grandTotalPenalties);
    }
}
