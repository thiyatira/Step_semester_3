package encapsulation.class_problems;

import java.util.Arrays;

/**
 * Week 5 Practice - Problem 5: Immutable Discharge Summary
 * Represents an immutable legal discharge document with validated medication codes and defensive copies.
 */
public class DischargeSummary {
    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be blank.");
        }
        if (medicationCodes == null) {
            throw new IllegalArgumentException("Medication codes array cannot be null.");
        }

        // Validate each medication code against format: MED-[A-Z]
        for (String code : medicationCodes) {
            if (code == null || !code.matches("^MED-[A-Z]$")) {
                throw new IllegalArgumentException("Invalid medication code format: must be MED-[A-Z], got " + code);
            }
        }

        this.patientId = patientId.trim();
        // Defensive copy on the way in
        this.medicationCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public String getPatientId() {
        return patientId;
    }

    // Defensive copy on the way out
    public String[] getMedicationCodes() {
        return Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    // With-style mutator returning a brand new immutable object
    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (index < 0 || index >= medicationCodes.length) {
            throw new IndexOutOfBoundsException("Invalid medication index: " + index);
        }
        String[] updated = Arrays.copyOf(medicationCodes, medicationCodes.length);
        updated[index] = newCode;
        return new DischargeSummary(this.patientId, updated);
    }
}
