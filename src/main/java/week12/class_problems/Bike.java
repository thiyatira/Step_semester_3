package week12.class_problems;

// Calculates a bike fare including waiting time.
public class Bike extends Ride {
    private final int waitingMinutes;

    public Bike(double distance, int waitingMinutes) {
        super(distance);
        if (waitingMinutes < 0) {
            throw new IllegalArgumentException("Waiting time cannot be negative");
        }
        this.waitingMinutes = waitingMinutes;
    }

    @Override
    public double calculateFare() {
        return 20 + 10 * getDistance() + 2.0 * waitingMinutes;
    }
}
