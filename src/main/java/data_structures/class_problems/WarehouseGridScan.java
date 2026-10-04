package data_structures.class_problems;

// Scans 2D warehouse floor grids to compute total inventory and first peak bin coordinates.
public class WarehouseGridScan {
    public static class WarehouseSummary {
        private final int totalItems;
        private final int maxRow;
        private final int maxCol;

        public WarehouseSummary(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public int getMaxRow() {
            return maxRow;
        }

        public int getMaxCol() {
            return maxCol;
        }

        @Override
        public String toString() {
            return "total = " + totalItems + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static WarehouseSummary warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new WarehouseSummary(0, -1, -1);
        }
        int total = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new WarehouseSummary(total, maxRow, maxCol);
    }
}
