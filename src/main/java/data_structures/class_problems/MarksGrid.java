package data_structures.class_problems;

import java.util.Arrays;

// 2D marks grid that tracks subject scores per student and reports toppers.
public class MarksGrid {
    private final String[] subjects;
    private final String[] studentNames;
    private final int[][] grid;
    private int count;

    public MarksGrid(String[] subjects) {
        this.subjects = Arrays.copyOf(subjects, subjects.length);
        this.studentNames = new String[50];
        this.grid = new int[50][subjects.length];
        this.count = 0;
    }

    public void addStudent(String name, int[] marks) {
        studentNames[count] = name;
        for (int i = 0; i < subjects.length; i++) {
            grid[count][i] = (i < marks.length) ? marks[i] : 0;
        }
        count++;
    }

    public int getTotal(String name) {
        for (int i = 0; i < count; i++) {
            if (studentNames[i].equals(name)) {
                int total = 0;
                for (int m : grid[i]) total += m;
                return total;
            }
        }
        throw new IllegalArgumentException("Student not found: " + name);
    }

    public void printToppers() {
        for (int s = 0; s < subjects.length; s++) {
            int best = -1;
            String topper = "";
            for (int i = 0; i < count; i++) {
                if (grid[i][s] > best) {
                    best   = grid[i][s];
                    topper = studentNames[i];
                }
            }
            System.out.println(subjects[s] + ": " + topper + " " + best);
        }
    }
}
