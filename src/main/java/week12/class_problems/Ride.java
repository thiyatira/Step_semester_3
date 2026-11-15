package week12.class_problems;

// Defines the common distance and fare contract for rides.
public abstract class Ride {
    private final double distance;

    protected Ride(double distance) {
        if (!Double.isFinite(distance) || distance < 1 || distance > 100) {
            throw new IllegalArgumentException("Distance must be between 1 and 100 km");
        }
        this.distance = distance;
    }

    protected double getDistance() {
        return distance;
    }

    public abstract double calculateFare();
}
