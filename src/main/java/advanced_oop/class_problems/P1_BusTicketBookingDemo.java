package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 1: Bus Ticket Booking Demo
 */
public class P1_BusTicketBookingDemo {

    public static void main(String[] args) {
        String[][] rawBookings = {
            {"Divya", "Chennai"},
            {"", "Bangalore"},
            {"Ravi123", "Pune"},
            {"Divya", "Chennai"},
            {"    ", "   "}
        };

        System.out.println("=== Batch Processing Bus Tickets ===");
        BusTicket.processBatch(rawBookings);

        System.out.println("\n=== Idempotent / Repeated Check-in Test ===");
        BusTicket single = new BusTicket("Karthik", "Hyderabad");
        single.markCheckedIn();
        single.markCheckedIn();
    }
}
