package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 1: PatientRecord
 * Models a hospital patient record with appropriate field modifiers and constructor validation.
 */
public class PatientRecord {
    // 1. private: sensitive ID should not be exposed directly
    private String patientId;

    // 2. protected: ward information reachable by specialized subclass units
    protected String wardCode;

    // 3. package-private (default): vitals accessed within clinical care package
    double vitalsScore;

    // 4. public: general facility name accessible everywhere
    public String facilityName;

    // No default/no-argument constructor provided
    public PatientRecord(String patientId, String wardCode, double vitalsScore, String facilityName) {
        if (patientId == null || patientId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid patientId: must be at least 4 non-whitespace characters.");
        }
        this.patientId = patientId.trim();
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getWardCode() {
        return wardCode;
    }

    public double getVitalsScore() {
        return vitalsScore;
    }

    public String getFacilityName() {
        return facilityName;
    }
}
