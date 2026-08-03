package arrays.class_problems;

/**
 * Week 1 Practice - Problem 3: BMI Calculator for a Team
 * Computes BMI from height and weight and categorizes WHO wellness status.
 */
public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Invalid input data for wellness report.");
            return;
        }

        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-8.2f | %-12s%n", (i + 1), h, w, bmi, status);
        }
    }

    public static void main(String[] args) {
        // Parallel arrays for 10 employees
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.62};
        double[] weights = {70.0, 90.0, 78.0, 48.0, 65.0, 72.0, 85.0, 68.0, 95.0, 54.0};

        System.out.println("=== Corporate Wellness Program Report ===");
        printWellnessReport(heights, weights);
    }
}
