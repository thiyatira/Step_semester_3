package encapsulation.assigment_problems;

import java.util.Arrays;

/**
 * Week 5 Assignment - Problem 5: Immutable Loan Receipt
 * Represents an immutable circulation receipt with validated book ID formats and defensive copies.
 */
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be blank.");
        }
        if (bookIds == null) {
            throw new IllegalArgumentException("Book IDs array cannot be null.");
        }

        // Validate each book ID format: BK- followed by exactly 3 digits
        for (String id : bookIds) {
            if (id == null || !id.matches("^BK-\\d{3}$")) {
                throw new IllegalArgumentException("Invalid book ID format: must be BK-\\d{3}, got " + id);
            }
        }

        this.memberId = memberId.trim();
        // Defensive copy on the way in
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    // Defensive copy on the way out
    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    // With-style mutator returning brand new immutable object
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException("Invalid book ID index: " + index);
        }
        String[] updated = Arrays.copyOf(bookIds, bookIds.length);
        updated[index] = newId;
        return new LoanReceipt(this.memberId, updated);
    }
}
