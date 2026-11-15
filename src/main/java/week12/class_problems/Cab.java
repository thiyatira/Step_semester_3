package week12.class_problems;

// Calculates a cab fare including surge pricing.
public class Cab extends Ride {
    private final double surge;

    public Cab(double distance, double surge) {
        super(distance);
        if (!Double.isFinite(surge) || surge < 1 || surge > 3) {
            throw new IllegalArgumentException("Surge must be between 1 and 3");
        }
        this.surge = surge;
    }

    @Override
    public double calculateFare() {
        return (50 + 20 * getDistance()) * surge;
    }
}
