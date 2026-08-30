package advanced_oop.class_problems;

import java.util.Arrays;

/**
 * Week 4 Practice - Problem 2: FareSplitter Demo
 */
public class P2_FareSplitterDemo {

    public static void main(String[] args) {
        FareSplitter f1 = new FareSplitter("TRIP001", 100000.0, 3);
        System.out.println("TRIP001 (100000 / 3) breakdown: " + Arrays.toString(f1.fareBreakdown()));

        FareSplitter f2 = new FareSplitter("TRIP002", 500.0);
        System.out.println("TRIP002 (500 / 2 default) breakdown: " + Arrays.toString(f2.fareBreakdown()));

        FareSplitter f3 = new FareSplitter("TRIP003");
        System.out.println("TRIP003 (provisional 0.0) breakdown: " + Arrays.toString(f3.fareBreakdown()));

        System.out.println("Overdue check (2 confirmed, 3 expected): " + f1.isConfirmationOverdue(2, 3));
        System.out.println("Overdue check (3 confirmed, 3 expected): " + f1.isConfirmationOverdue(3, 3));
    }
}
