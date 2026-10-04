package data_structures.assigment_problems;

import java.util.Arrays;

// Demonstrates dynamic sliding window search for the longest budget-compliant snack run.
public class A2_BudgetStreakDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Longest Budget-Friendly Streak Demo ===");
        int[] costs1 = {4, 2, 1, 7, 3, 1, 2, 1, 5};
        long budget1 = 8;
        int[] result1 = BudgetFriendlyStreak.longestStreak(costs1, budget1);
        System.out.println("Costs: " + Arrays.toString(costs1) + ", Budget: " + budget1);
        System.out.println("Expected: (4, 4)");
        System.out.println("Actual  : (" + result1[0] + ", " + result1[1] + ")");

        int[] costs2 = {9, 10};
        long budget2 = 8;
        int[] result2 = BudgetFriendlyStreak.longestStreak(costs2, budget2);
        System.out.println("\nCosts: " + Arrays.toString(costs2) + ", Budget: " + budget2);
        System.out.println("Expected: (0, -1)");
        System.out.println("Actual  : (" + result2[0] + ", " + result2[1] + ")");
    }
}
