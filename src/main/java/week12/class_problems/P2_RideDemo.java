package week12.class_problems;

// Prices several ride types through their common contract.
public class P2_RideDemo {
    public static void main(String[] args) {
        Ride[] rides = {new Auto(4), new Cab(6, 1.5), new Bike(3, 5)};
        double total = 0;
        for (Ride ride : rides) {
            double fare = ride.calculateFare();
            total += fare;
            System.out.printf("%s: %.0f%n", ride.getClass().getSimpleName(), fare);
        }
        System.out.printf("Total: %.0f%n", total);
    }
}
