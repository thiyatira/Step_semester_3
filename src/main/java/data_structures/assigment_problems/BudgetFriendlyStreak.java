package data_structures.assigment_problems;

// Finds the longest consecutive run of study session snack days fitting a fixed budget.
public class BudgetFriendlyStreak {
    public static int[] longestStreak(int[] costs, long budget) {
        if (costs == null || costs.length == 0 || budget < 0) {
            return new int[]{0, -1};
        }

        int maxLen = 0;
        int bestStart = -1;
        long currentSum = 0;
        int left = 0;

        for (int right = 0; right < costs.length; right++) {
            currentSum += costs[right];

            while (currentSum > budget && left <= right) {
                currentSum -= costs[left];
                left++;
            }

            if (currentSum <= budget) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    bestStart = left;
                }
            }
        }

        if (maxLen == 0) {
            return new int[]{0, -1};
        }
        return new int[]{maxLen, bestStart};
    }
}
