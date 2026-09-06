package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 4: PatientProfile JavaBean
 * Supports chained constructors, JavaBean conventions, write-once ID, and write-only locker PIN.
 */
public class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    @SuppressWarnings("unused")
    private String lockerPin; // write-only field

    // 1. No-argument constructor
    public PatientProfile() {
        this(null, null);
    }

    // 2. Name-only constructor
    public PatientProfile(String name) {
        this(null, name);
    }

    // 3. ID + Name constructor (central target of chaining)
    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
        this.lockerPin = null;
    }

    public String getPatientId() {
        return patientId;
    }

    // Write-once property: only the first non-null write takes effect
    public void setPatientId(String id) {
        if (this.patientId == null && id != null && !id.trim().isEmpty()) {
            this.patientId = id.trim();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    // Write-only property: never retrievable via any getter
    public void setLockerPin(String pin) {
        this.lockerPin = pin;
    }
}
