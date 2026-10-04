package data_structures.assigment_problems;

// Generates clockwise spiral audit traversal order for rectangular warehouse storage bins.
public class SpiralStockAuditRoute {
    public static int[] auditRoute(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[0];
        }

        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[m * n];
        int idx = 0;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                result[idx++] = grid[top][c];
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                result[idx++] = grid[r][right];
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    result[idx++] = grid[bottom][c];
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    result[idx++] = grid[r][left];
                }
                left++;
            }
        }

        return result;
    }
}
