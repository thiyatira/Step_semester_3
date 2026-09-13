package inheritance_polymorphism.assigment_problems;

// Demonstration of marathon entry foundation validation and batch bib registration.
public class A1_BatchBibValidatorDemo {
    public static void main(String[] args) {
        try {
            new RaceEntry("B1", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected: " + e.getMessage());
        }

        RunnerEntry r = new RunnerEntry("BIB2001", 80, "Open 10K");
        r.pay(30);
        System.out.println("Balance due: " + r.getBalanceDue());

        String[] bibs = {"BIB1", "B1", "BIB2"};
        System.out.println(RaceEntry.registerBatch(bibs, 80));
    }
}
