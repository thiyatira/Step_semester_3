package data_structures.class_problems;

import java.util.Arrays;

// Demonstrates two-pointer pair sum retrieval on sorted financial balances.
public class P1_PairSumDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Pair Sum in a Sorted Array Demo ===");
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        int target1 = 4;
        int[] res1 = PairSumSorted.pairSumSorted(nums1, target1);
        System.out.println("Input: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Output: " + (res1 != null ? "(" + res1[0] + ", " + res1[1] + ")" : "Not Found"));

        int[] nums2 = {1, 2, 3};
        int target2 = 100;
        int[] res2 = PairSumSorted.pairSumSorted(nums2, target2);
        System.out.println("Input: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Output: " + (res2 != null ? "(" + res2[0] + ", " + res2[1] + ")" : "Not Found"));
    }
}
