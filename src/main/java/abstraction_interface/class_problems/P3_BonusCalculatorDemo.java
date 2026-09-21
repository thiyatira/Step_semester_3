package abstraction_interface.class_problems;

// Demonstration of abstract StaffMember, constructor chaining, JavaBean encapsulation, and Auditable interface.
public class P3_BonusCalculatorDemo {
    public static void main(String[] args) {
        // Constructor with default bonusRate (10%)
        TeamLead t = new TeamLead(60000, 5);
        System.out.println("Bonus (default 10%): " + t.calculateBonus());

        // Constructor with explicit bonusRate (20%)
        TeamLead t2 = new TeamLead(60000, 0.20, 5);
        System.out.println("Bonus (explicit 20%): " + t2.calculateBonus());

        // Negative salary validation rejection
        t.setSalary(-5000);
        System.out.println("Current salary after invalid set: " + t.getSalary());

        // Upcasting: TeamLead stored as StaffMember parent reference
        StaffMember ref = t;
        System.out.println(StaffMember.getAuditIfApplicable(ref));
    }
}
