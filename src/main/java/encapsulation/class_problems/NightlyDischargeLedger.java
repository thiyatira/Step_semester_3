package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 5: Nightly Discharge Ledger
 * Processes batch of discharge summaries safely handling nulls and distinguishing critical-care variants.
 */
public class NightlyDischargeLedger {

    // One-time static setup
    private static final String LEDGER_TAG;
    static {
        LEDGER_TAG = "MEDITRACK-RECONCILIATION";
    }

    public static String getLedgerTag() {
        return LEDGER_TAG;
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        if (summaries == null) {
            return "0 processed | 0 null skipped | 0 critical-care | 0 routine";
        }

        int processed = 0;
        int nullSkipped = 0;
        int criticalCareCount = 0;
        int routineCount = 0;

        for (DischargeSummary summary : summaries) {
            if (summary == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            if (summary instanceof CriticalCareDischargeSummary) {
                criticalCareCount++;
            } else {
                routineCount++;
            }
        }

        String result = String.format("%d processed | %d null skipped | %d critical-care | %d routine",
                processed, nullSkipped, criticalCareCount, routineCount);
        return result;
    }
}
