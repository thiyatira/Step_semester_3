package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 5: Bus Ticket Account
 * Supports static initialization block, chained constructor, and final penalty method.
 */
public class BusTicketAccount {
    protected String bookingId;
    protected double ticketFare;

    // Static initialization block for class-level configuration
    protected static double baseLateRatePerMinute;
    static {
        baseLateRatePerMinute = 15.0; // Rs 15 per minute late
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be empty.");
        }
        if (ticketFare < 0) {
            throw new IllegalArgumentException("Ticket fare cannot be negative.");
        }
        this.bookingId = bookingId.trim();
        this.ticketFare = ticketFare;
    }

    // Provisional constructor chained via this(...)
    public BusTicketAccount(String bookingId) {
        this(bookingId, 1000.0);
    }

    public String getBookingId() {
        return bookingId;
    }

    public double getTicketFare() {
        return ticketFare;
    }

    public final double calculatePenalty(int minutesLate) {
        if (minutesLate <= 0) return 0.0;
        return minutesLate * baseLateRatePerMinute;
    }
}
