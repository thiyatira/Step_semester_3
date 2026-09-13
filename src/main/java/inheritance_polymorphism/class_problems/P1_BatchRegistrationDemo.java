package inheritance_polymorphism.class_problems;

// Demonstration of single-inheritance ticket creation and batch ID registration.
public class P1_BatchRegistrationDemo {
    public static void main(String[] args) {
        try {
            new EventTicket("ST1", 500);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected: " + e.getMessage());
        }

        WorkshopTicket w = new WorkshopTicket("STU2", 1200, "AI/ML");
        w.pay(500);
        System.out.println("Balance due: " + w.getBalanceDue());

        String[] batch = {"STU1", "ST1", "STU2", "  ", "STU3"};
        System.out.println(EventTicket.registerBatch(batch, 500));
    }
}
