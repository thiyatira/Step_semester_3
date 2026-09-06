package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 3: Book Copy Circulation Guard
 * Strictly enforces copy availability bounds: 0 <= copiesAvailable <= copiesTotal.
 */
public class BookInventory {
    private final int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            throw new IllegalArgumentException("Total copies must be greater than zero.");
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void checkOut() {
        // Silently reject underflow if no copies are available
        if (copiesAvailable <= 0) {
            return;
        }
        copiesAvailable--;
    }

    public void checkIn() {
        // Silently reject overflow if all copies are already accounted for
        if (copiesAvailable >= copiesTotal) {
            return;
        }
        copiesAvailable++;
    }
}
