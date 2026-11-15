package week12.class_problems;

// Calculates an auto ride fare.
public class Auto extends Ride {
    public Auto(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 30 + 15 * getDistance();
    }
}
