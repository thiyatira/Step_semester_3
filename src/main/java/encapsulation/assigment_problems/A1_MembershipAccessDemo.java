package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 1 Demo
 */
public class A1_MembershipAccessDemo {

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"private\", \"SAME_CLASS\"): " +
                AccessChecker.classifyAccess("private", "SAME_CLASS"));

        System.out.println("classifyAccess(\"protected\", \"DIFFERENT_PACKAGE\"): " +
                AccessChecker.classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println("summarizeByModifier: " + AccessChecker.summarizeByModifier(attempts));

        // Test constructor validation
        try {
            System.out.println("Attempting to construct LibraryMember with \"LB9\" (too short)...");
            new LibraryMember("LB9", "BR1", 0, "Priya Nair");
        } catch (IllegalArgumentException e) {
            System.out.println("Construction Rejected: " + e.getMessage());
        }

        LibraryMember valid = new LibraryMember("LB94", "BR1", 0, "Priya Nair");
        System.out.println("Valid LibraryMember created for: " + valid.getMembershipId());
    }
}
