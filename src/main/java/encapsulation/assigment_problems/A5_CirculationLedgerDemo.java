package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 5 Demo
 */
public class A5_CirculationLedgerDemo {

    public static void main(String[] args) {
        // Format validation check
        try {
            System.out.println("Attempting to construct with invalid book ID \"bad\"...");
            new LoanReceipt("LIB-8841", new String[]{"BK-100", "bad"});
        } catch (IllegalArgumentException e) {
            System.out.println("Construction Rejected: " + e.getMessage());
        }

        // Defensive copying check
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println("Original r bookId[0]: " + r.getBookIds()[0] + " (unmodified)");

        // With-style mutator
        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println("Corrected receipt bookId[1]: " + corrected.getBookIds()[1]);

        // Batch processing with null-safety
        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };

        String summary = NightlyCirculationLedger.processNightlyCirculation(batch);
        System.out.println("Batch Summary: " + summary);
    }
}
