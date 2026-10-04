package data_structures.class_problems;

// Runs warehouse floor inventory scanning and maximum bin localization verification.
public class P2_WarehouseScanDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Warehouse Bin Grid Scan Demo ===");
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        WarehouseGridScan.WarehouseSummary summary = WarehouseGridScan.warehouseSummary(grid);
        System.out.println("Warehouse Grid: 3x3");
        System.out.println("Expected: total = 49, maxCoordinate = (2, 1)");
        System.out.println("Actual  : " + summary);
    }
}
