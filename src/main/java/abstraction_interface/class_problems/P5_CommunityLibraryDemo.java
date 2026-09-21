package abstraction_interface.class_problems;

// Demonstration of LibraryItem abstract hierarchy, multiple interfaces, and Object instanceof Reservable checking.
public class P5_CommunityLibraryDemo {
    public static void main(String[] args) {
        Textbook t = new Textbook("Java Fundamentals");
        System.out.println("Loan period: " + t.getLoanPeriodDays());
        System.out.println(t.renew());
        System.out.println(t.reserve());

        Magazine m = new Magazine("Tech Monthly");
        System.out.println("Magazine reservation: " + LibraryItem.reserveIfSupported(m));

        DigitalPass d = new DigitalPass("E-Journal Access");
        System.out.println("DigitalPass reservation: " + LibraryItem.reserveIfSupported(d));

        // Upcasting: Textbook stored as LibraryItem
        LibraryItem ref = t;
        System.out.println("Upcasted Textbook reservation: " + LibraryItem.reserveIfSupported(ref));

        // Batch processing
        LibraryItem[] items = {t, m};
        LibraryItem.processCheckouts(items);
    }
}
