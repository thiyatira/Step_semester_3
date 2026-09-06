package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 5: Reference Only Loan Receipt Subclass
 * Specialized immutable loan receipt for in-library reading room materials.
 */
public class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Room number cannot be blank.");
        }
        this.roomNumber = roomNumber.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
