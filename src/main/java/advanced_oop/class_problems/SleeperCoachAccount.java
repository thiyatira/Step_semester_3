package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 5: SleeperCoachAccount Subclass
 * Represents specialized sleeper coach bookings settled differently in nightly reconciliation.
 */
public class SleeperCoachAccount extends BusTicketAccount {

    public SleeperCoachAccount(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }

    public SleeperCoachAccount(String bookingId) {
        super(bookingId, 1800.0);
    }
}
