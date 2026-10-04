package data_structures.class_problems;

import java.util.Arrays;

// Solves two-sum reconciliation target on pre-sorted array using two pointers.
public class PairSumSorted {
    public static int[] pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
