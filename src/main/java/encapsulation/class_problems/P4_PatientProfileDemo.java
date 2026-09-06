package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 4: PatientProfile Demo
 */
public class P4_PatientProfileDemo {

    public static void main(String[] args) {
        // Name-only constructor
        PatientProfile p1 = new PatientProfile("Arjun Iyer");
        System.out.println("p1 ID (name-only): " + p1.getPatientId());
        System.out.println("p1 Name: " + p1.getName());

        // ID + Name constructor
        PatientProfile p2 = new PatientProfile("MT2026-0142", "Arjun Iyer");
        System.out.println("p2 ID: " + p2.getPatientId());

        // Write-once demonstration
        PatientProfile p = new PatientProfile();
        p.setPatientId("MT2026-0142");
        p.setPatientId("HACKED-0000"); // second call ignored
        System.out.println("Write-once ID result: " + p.getPatientId());

        // Write-only locker PIN
        p.setLockerPin("4829");
        System.out.println("Locker PIN set successfully (write-only, no getter exists).");
    }
}
