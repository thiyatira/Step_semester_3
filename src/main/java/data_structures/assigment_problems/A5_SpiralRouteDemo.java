package data_structures.assigment_problems;

import java.util.Arrays;

// Verifies clockwise spiral navigation across rectangular warehouse floor bin grids.
public class A5_SpiralRouteDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 5: Spiral Stock Audit Route Demo ===");
        int[][] grid = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        int[] route = SpiralStockAuditRoute.auditRoute(grid);
        System.out.println("Grid: 3x4");
        System.out.println("Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println("Actual  : " + Arrays.toString(route));
    }
}
