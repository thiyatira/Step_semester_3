package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 1: Field Visibility & Intake Validator Demo
 */
public class P1_FieldVisibilityDemo {

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"private\", \"SAME_CLASS\"): " +
                AccessRuleEngine.classifyAccess("private", "SAME_CLASS"));

        System.out.println("classifyAccess(\"default\", \"DIFFERENT_PACKAGE\"): " +
                AccessRuleEngine.classifyAccess("default", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("summarizeBatch: " + AccessRuleEngine.summarizeBatch(batch));

        // Test constructor validation
        try {
            System.out.println("Attempting to construct PatientRecord with \"MT9\" (too short)...");
            new PatientRecord("MT9", "W3", 98.2, "MediTrack Central");
        } catch (IllegalArgumentException e) {
            System.out.println("Construction Rejected: " + e.getMessage());
        }

        PatientRecord validRecord = new PatientRecord("MT94", "W3", 98.2, "MediTrack Central");
        System.out.println("Valid PatientRecord created for ID: " + validRecord.getPatientId());
    }
}
