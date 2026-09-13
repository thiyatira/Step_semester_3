package inheritance_polymorphism.class_problems;

// Demonstration of multilevel and hierarchical ticket inheritance and polymorphic balance summation.
public class P2_FamilyTreeDemo {
    public static void main(String[] args) {
        EventTicket standardTicket = new EventTicket("STU1", 500);
        WorkshopTicket workshopTicket = new WorkshopTicket("STU2", 1200, "AI/ML");
        PremiumWorkshopTicket premiumTicket = new PremiumWorkshopTicket("STU3", 2000, "Cloud Native", 300);
        HackathonTicket hackathonTicket = new HackathonTicket("STU4", 800, "Byte Force");

        System.out.println(standardTicket.printTicket());
        System.out.println(workshopTicket.printTicket());
        System.out.println(premiumTicket.printTicket());
        System.out.println(hackathonTicket.printTicket());

        System.out.println(EventTicket.classifyGeneration(premiumTicket));
        System.out.println(EventTicket.classifyGeneration(hackathonTicket));

        EventTicket[] mixedFleet = {standardTicket, workshopTicket, premiumTicket, hackathonTicket};
        System.out.println("Total Balance Due: " + EventTicket.getTotalBalanceDue(mixedFleet));
    }
}
