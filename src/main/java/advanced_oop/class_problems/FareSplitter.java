package advanced_oop.class_problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Week 4 Practice - Problem 2: Remainder-Fair FareSplitter
 * Links 3 constructors via this(...) and guarantees exact revenue preservation without rounding loss.
 */
public class FareSplitter {
    private String tripId;
    private double totalFare;
    private int passengerCount;

    // Full 3-argument constructor
    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (tripId == null || tripId.trim().isEmpty()) {
            throw new IllegalArgumentException("Trip ID cannot be blank.");
        }
        if (totalFare < 0) {
            throw new IllegalArgumentException("Total fare cannot be negative.");
        }
        if (passengerCount <= 0) {
            throw new IllegalArgumentException("Passenger count must be positive.");
        }
        this.tripId = tripId.trim();
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    // 2-argument constructor chaining via this(...)
    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    // 1-argument provisional constructor chaining via this(...)
    public FareSplitter(String tripId) {
        this(tripId, 0.0, 2);
    }

    public String getTripId() {
        return tripId;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public double[] fareBreakdown() {
        double[] breakdown = new double[passengerCount];
        if (totalFare == 0.0) {
            return breakdown;
        }

        BigDecimal total = BigDecimal.valueOf(totalFare).setScale(2, RoundingMode.HALF_UP);
        BigDecimal count = BigDecimal.valueOf(passengerCount);

        // Base share truncated/floored to 2 decimal places
        BigDecimal baseShare = total.divide(count, 2, RoundingMode.DOWN);

        BigDecimal runningSum = BigDecimal.ZERO;
        for (int i = 0; i < passengerCount - 1; i++) {
            breakdown[i] = baseShare.doubleValue();
            runningSum = runningSum.add(baseShare);
        }

        // The final share absorbs any remainder to guarantee total equality
        BigDecimal lastShare = total.subtract(runningSum);
        breakdown[passengerCount - 1] = lastShare.doubleValue();

        return breakdown;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }
}
