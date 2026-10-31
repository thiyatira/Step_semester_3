package data_structures.assigment_problems;

// Demo runner for the fire drill exit distances.
public class A5_FireDrillDemo {
    public static void main(String[] args) {
        FireDrillPlanner planner = new FireDrillPlanner();

        char[][] plan = {
            {'.', '#', '.', 'E'},
            {'.', '.', '.', '#'},
            {'E', '#', '.', '.'}
        };
        print(planner.exitDistance(plan));

        System.out.println();
        char[][] sealed = {
            {'.', '#', 'E'},
            {'.', '#', '.'}
        };
        print(planner.exitDistance(sealed));
    }

    private static void print(int[][] grid) {
        for (int[] row : grid) {
            StringBuilder line = new StringBuilder();
            for (int value : row) {
                line.append(value).append(' ');
            }
            System.out.println(line.toString().trim());
        }
    }
}
