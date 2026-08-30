package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 4: Tiered Boarding Penalty Calculator
 * Implements final modifiers, tiered penalty calculation, and minimum floor enforcement.
 */
public final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        if (minimumPenaltyPercent < 0) {
            throw new IllegalArgumentException("Minimum penalty percent cannot be negative.");
        }
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Ticket fare and minutes late cannot be negative.");
        }

        // On-time boarding: penalty floor never applies
        if (minutesLate == 0) {
            return 0.0;
        }

        double tieredPenalty = 0.0;

        // Tier 1: Minutes 1-5 @ 0.5% per minute
        int tier1Mins = Math.min(minutesLate, 5);
        tieredPenalty += tier1Mins * (0.005 * ticketFare);

        // Tier 2: Minutes 6-15 @ 1.0% per minute
        if (minutesLate > 5) {
            int tier2Mins = Math.min(minutesLate - 5, 10);
            tieredPenalty += tier2Mins * (0.010 * ticketFare);
        }

        // Tier 3: Minute 16+ @ 2.0% per minute
        if (minutesLate > 15) {
            int tier3Mins = minutesLate - 15;
            tieredPenalty += tier3Mins * (0.020 * ticketFare);
        }

        // Apply minimum penalty percentage floor for late boarders
        double floor = ticketFare * (minimumPenaltyPercent / 100.0);
        return Math.max(tieredPenalty, floor);
    }
}
