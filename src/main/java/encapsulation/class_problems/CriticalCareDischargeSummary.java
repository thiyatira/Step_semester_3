package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 5: Critical Care Discharge Summary
 * Specialized immutable discharge summary for ICU critical-care patients.
 */
public class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;

    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        if (icuDays < 0) {
            throw new IllegalArgumentException("ICU days cannot be negative.");
        }
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }
}
