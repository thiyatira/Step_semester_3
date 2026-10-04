package data_structures.assigment_problems;

import java.util.Arrays;

// Verifies instant prefix sum range querying for shopping mall visitor metrics.
public class A1_MallFootfallDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Mall Footfall Range Report Demo ===");
        int[] visitors = {12, 7, 3, 9, 15, 4, 8};
        int[][] queries = {
            {0, 2},
            {2, 5},
            {4, 6},
            {3, 3}
        };

        int[] actual = MallFootfallReport.footfallReport(visitors, queries);
        System.out.println("Visitors: " + Arrays.toString(visitors));
        System.out.println("Queries : (0, 2), (2, 5), (4, 6), (3, 3)");
        System.out.println("Expected: [22, 31, 27, 9]");
        System.out.println("Actual  : " + Arrays.toString(actual));
    }
}
