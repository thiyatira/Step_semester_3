package data_structures.assigment_problems;

import java.util.HashMap;
import java.util.Map;

// Counts contiguous transaction periods summing to target net balance using prefix hash map.
public class NetBalancePeriodCounter {
    public static int countPeriods(int[] transactions, long k) {
        if (transactions == null || transactions.length == 0) {
            return 0;
        }

        Map<Long, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0L, 1);

        long currentSum = 0;
        int count = 0;

        for (int tx : transactions) {
            currentSum += tx;
            long complement = currentSum - k;
            if (prefixCounts.containsKey(complement)) {
                count += prefixCounts.get(complement);
            }
            prefixCounts.put(currentSum, prefixCounts.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
