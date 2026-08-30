package advanced_oop.assigment_problems;

// Question 4: Exam-Week Surge Fee Calculator
// final class and final method
public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        if(minimumSurgePercent < 0) {
            throw new IllegalArgumentException("Minimum surge percent cannot be negative.");
        }
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if(orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Values cannot be negative.");
        }

        // on-time orders have 0 surge fee, floor does not apply
        if(delayMinutes == 0) {
            return 0.0;
        }

        double percent = 0.0;

        // 1 to 5 mins: 0.5% per min
        int b1 = Math.min(delayMinutes, 5);
        percent += b1 * 0.5;

        // 6 to 15 mins: 1.0% per min
        if(delayMinutes > 5) {
            int b2 = Math.min(delayMinutes - 5, 10);
            percent += b2 * 1.0;
        }

        // 16 mins onward: 2.0% per min
        if(delayMinutes > 15) {
            int b3 = delayMinutes - 15;
            percent += b3 * 2.0;
        }

        double tiered = (percent / 100.0) * orderValue;
        double floor = (minimumSurgePercent / 100.0) * orderValue;

        // charge whichever is higher between tiered fee and minimum floor
        return Math.max(tiered, floor);
    }
}
