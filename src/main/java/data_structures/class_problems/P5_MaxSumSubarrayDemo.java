package data_structures.class_problems;

import java.util.Arrays;

// Evaluates optimal fixed-window sliding subarray total sales over daily revenue records.
public class P5_MaxSumSubarrayDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: Maximum Sum Subarray of Fixed Size K Demo ===");
        int[] sales = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int max = MaxSumSubarray.maxSumSubarray(sales, k);
        System.out.println("Sales: " + Arrays.toString(sales) + ", k = " + k);
        System.out.println("Expected: 9");
        System.out.println("Actual  : " + max);

        int[] sales2 = {10, 20, 30};
        int k2 = 1;
        int max2 = MaxSumSubarray.maxSumSubarray(sales2, k2);
        System.out.println("\nSales: " + Arrays.toString(sales2) + ", k = " + k2);
        System.out.println("Expected: 30");
        System.out.println("Actual  : " + max2);
    }
}
