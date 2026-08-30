package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 4: Tiered Penalty Demo
 */
public class P4_TieredPenaltyDemo {

    public static void main(String[] args) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0); // 1.0% floor

        System.out.println("ticketFare = 1000, minutesLate = 0  -> Rs " + calc.calculatePenalty(1000.0, 0));
        System.out.println("ticketFare = 1000, minutesLate = 1  -> Rs " + calc.calculatePenalty(1000.0, 1));
        System.out.println("ticketFare = 1000, minutesLate = 16 -> Rs " + calc.calculatePenalty(1000.0, 16));
    }
}
