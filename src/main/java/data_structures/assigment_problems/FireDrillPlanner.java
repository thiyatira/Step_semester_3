package data_structures.assigment_problems;

import java.util.ArrayDeque;
import java.util.Queue;

// Finds the shortest distance from every room to the nearest exit with one multi-source BFS.
public class FireDrillPlanner {

    private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] exitDistance(char[][] plan) {
        if (plan == null) {
            throw new IllegalArgumentException("plan must not be null");
        }
        int rows = plan.length;
        int[][] dist = new int[rows][];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            dist[r] = new int[plan[r].length];
            for (int c = 0; c < plan[r].length; c++) {
                dist[r][c] = -1;
                if (plan[r][c] == 'E') {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] move : MOVES) {
                int nr = cell[0] + move[0];
                int nc = cell[1] + move[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= plan[nr].length) {
                    continue;
                }
                if (plan[nr][nc] == '.' && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }
}
