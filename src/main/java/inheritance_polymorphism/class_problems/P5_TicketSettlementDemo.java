package inheritance_polymorphism.class_problems;

// Demonstration of static ticket counting, promo code validation, and null-safe nightly settlement.
public class P5_TicketSettlementDemo {
    public static void main(String[] args) {
        EventTicket t1 = new EventTicket(500);
        System.out.println("Assigned Ticket ID: " + t1.ticketId);
        System.out.println("Tickets Issued So Far: " + EventTicket.getTicketsIssued());

        System.out.println("isValidPromoCode(\"F123A\"): " + EventTicket.isValidPromoCode("F123A"));
        System.out.println("isValidPromoCode(\"F12A\"): " + EventTicket.isValidPromoCode("F12A"));
        System.out.println("isValidPromoCode(\"X123A\"): " + EventTicket.isValidPromoCode("X123A"));

        t1.pay(200);
        t1.pay(200, "UPI");
        System.out.println("Remaining Balance: " + t1.getBalanceDue());

        EventTicket[] settlementBatch = {
            new GroupTicket(2000, 5),
            null,
            new EventTicket(500)
        };
        System.out.println("Nightly Settlement: " + EventTicket.processNightlySettlement(settlementBatch));
    }
}
