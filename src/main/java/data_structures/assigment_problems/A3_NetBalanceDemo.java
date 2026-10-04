package data_structures.assigment_problems;

import java.util.Arrays;

// Verifies counting of periods with exact net transaction sums in wallet audit logs.
public class A3_NetBalanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Net-Balance Period Counter Demo ===");
        int[] tx1 = {3, 4, -7, 1, 3, 3, 1, -4};
        long k1 = 7;
        int count1 = NetBalancePeriodCounter.countPeriods(tx1, k1);
        System.out.println("Transactions: " + Arrays.toString(tx1) + ", Target k: " + k1);
        System.out.println("Expected: 4");
        System.out.println("Actual  : " + count1);

        int[] tx2 = {1, 2, 3};
        long k2 = 10;
        int count2 = NetBalancePeriodCounter.countPeriods(tx2, k2);
        System.out.println("\nTransactions: " + Arrays.toString(tx2) + ", Target k: " + k2);
        System.out.println("Expected: 0");
        System.out.println("Actual  : " + count2);
    }
}
