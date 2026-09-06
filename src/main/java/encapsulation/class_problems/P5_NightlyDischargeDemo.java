package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 5: Nightly Discharge Demo
 */
public class P5_NightlyDischargeDemo {

    public static void main(String[] args) {
        // Format validation check
        try {
            System.out.println("Attempting to construct with invalid code \"bad\"...");
            new DischargeSummary("MT2026-0142", new String[]{"MED-A", "bad"});
        } catch (IllegalArgumentException e) {
            System.out.println("Construction Rejected: " + e.getMessage());
        }

        // Defensive copying proof
        DischargeSummary d = new DischargeSummary("MT2026-0142", new String[]{"MED-A", "MED-B"});
        String[] codes = d.getMedicationCodes();
        codes[0] = "TAMPERED";
        System.out.println("Original d code[0]: " + d.getMedicationCodes()[0] + " (unmodified)");

        // With-style modification
        DischargeSummary corrected = d.withCorrectedMedication(1, "MED-C");
        System.out.println("Corrected summary code[1]: " + corrected.getMedicationCodes()[1]);

        // Batch processing with null handling
        DischargeSummary[] batch = {
            new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4),
            null,
            new DischargeSummary("MT002", new String[]{"MED-Y"})
        };

        String result = NightlyDischargeLedger.processNightlyBatch(batch);
        System.out.println("Batch Result: " + result);
    }
}
