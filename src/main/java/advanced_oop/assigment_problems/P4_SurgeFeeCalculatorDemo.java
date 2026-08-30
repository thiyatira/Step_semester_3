package advanced_oop.assigment_problems;

// testing surge fee calculator
public class P4_SurgeFeeCalculatorDemo {
    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0); // 1.0% minimum surge floor

        double fee0 = calc.calculateSurgeFee(500, 0);
        double fee1 = calc.calculateSurgeFee(500, 1);
        double fee16 = calc.calculateSurgeFee(500, 16);

        System.out.println("orderValue = 500, delayMinutes = 0  -> Rs " + fee0);
        System.out.println("orderValue = 500, delayMinutes = 1  -> Rs " + fee1);
        System.out.println("orderValue = 500, delayMinutes = 16 -> Rs " + fee16);
    }
}
