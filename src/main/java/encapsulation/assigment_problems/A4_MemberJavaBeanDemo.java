package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 4 Demo
 */
public class A4_MemberJavaBeanDemo {

    public static void main(String[] args) {
        // Partial constructor
        LibraryMemberProfile m1 = new LibraryMemberProfile("Priya Nair");
        System.out.println("m1 ID (name-only): " + m1.getMembershipId());
        System.out.println("m1 Name: " + m1.getName());

        // ID + Name constructor
        LibraryMemberProfile m2 = new LibraryMemberProfile("LIB-8841", "Priya Nair");
        System.out.println("m2 ID: " + m2.getMembershipId());

        // Write-once demonstration
        LibraryMemberProfile m = new LibraryMemberProfile();
        m.setMembershipId("LIB-8841");
        m.setMembershipId("FAKE-0000"); // second call ignored
        System.out.println("Write-once ID result: " + m.getMembershipId());

        // Write-only security answer
        m.setSecurityAnswer("Blue Lake");
        System.out.println("Security answer set successfully (write-only, no getter exists).");
    }
}
