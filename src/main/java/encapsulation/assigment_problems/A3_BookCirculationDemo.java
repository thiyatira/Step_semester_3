package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 3 Demo
 */
public class A3_BookCirculationDemo {

    public static void main(String[] args) {
        // Boundary check on construction
        try {
            System.out.println("Attempting to construct BookInventory with 0 copies...");
            new BookInventory(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Construction Rejected: " + e.getMessage());
        }

        // Underflow prevention
        BookInventory b = new BookInventory(3);
        System.out.println("Initial available copies: " + b.getCopiesAvailable());
        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut(); // 4th checkout silently rejected
        System.out.println("Copies available after 4 checkouts: " + b.getCopiesAvailable() + " (never negative)");

        // Overflow prevention
        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn(); // 4th check-in silently rejected
        System.out.println("Copies available after 4 check-ins: " + b.getCopiesAvailable() + " (never exceeds copiesTotal)");
    }
}
