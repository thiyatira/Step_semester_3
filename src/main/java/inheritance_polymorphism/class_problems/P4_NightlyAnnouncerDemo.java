package inheritance_polymorphism.class_problems;

// Demonstration of polymorphic announcements and guarded downcasting for specific ticket properties.
public class P4_NightlyAnnouncerDemo {
    public static void main(String[] args) {
        EventTicket[] tickets = {
            new EventTicket(500),
            new WorkshopTicket(1200, "AI/ML")
        };
        System.out.println(EventTicket.batchPrint(tickets));

        try {
            EventTicket plain = new EventTicket(500);
            WorkshopTicket bad = (WorkshopTicket) plain;
            System.out.println(bad.getTrack());
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught as expected: " + e.getMessage());
        }
    }
}
