package data_structures.assigment_problems;

import java.util.Arrays;

// Demonstrates boundary-based binary search querying across university exam score records.
public class A4_ExamScoreBandDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: Exam Score Band Counter Demo ===");
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        int low1 = 42, high1 = 58;
        int count1 = ExamScoreBandCounter.countInBand(scores, low1, high1);
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Band [" + low1 + ", " + high1 + "]");
        System.out.println("Expected: 6");
        System.out.println("Actual  : " + count1);

        int low2 = 90, high2 = 100;
        int count2 = ExamScoreBandCounter.countInBand(scores, low2, high2);
        System.out.println("\nBand [" + low2 + ", " + high2 + "]");
        System.out.println("Expected: 0");
        System.out.println("Actual  : " + count2);
    }
}
