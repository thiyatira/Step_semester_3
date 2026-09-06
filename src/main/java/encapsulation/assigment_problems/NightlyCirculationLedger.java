package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 5: Nightly Circulation Ledger
 * Batch reconciles loan receipts safely skipping nulls and categorizing reference-only checkouts.
 */
public class NightlyCirculationLedger {

    // One-time static setup
    private static final String SYSTEM_ID;
    static {
        SYSTEM_ID = "PAGETURNER-CIRCULATION-LEDGER";
    }

    public static String getSystemId() {
        return SYSTEM_ID;
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 reference-only | 0 regular";
        }

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnlyCount = 0;
        int regularCount = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnlyCount++;
            } else {
                regularCount++;
            }
        }

        return String.format("%d processed | %d null skipped | %d reference-only | %d regular",
                processed, nullSkipped, referenceOnlyCount, regularCount);
    }
}
