package data_structures.class_problems;

// Computes the maximum sum of any contiguous subarray of fixed size k using sliding window.
public class MaxSumSubarray {
    public static int maxSumSubarray(int[] sales, int k) {
        if (sales == null || k <= 0 || sales.length < k) {
            throw new IllegalArgumentException("Invalid array or window size k.");
        }

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += sales[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < sales.length; i++) {
            windowSum += sales[i] - sales[i - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }
}
