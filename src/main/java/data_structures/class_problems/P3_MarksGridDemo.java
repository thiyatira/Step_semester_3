package data_structures.class_problems;

// Demo: Student Marks Grid — totals and subject toppers with 2D arrays.
public class P3_MarksGridDemo {
    public static void main(String[] args) {
        MarksGrid grid = new MarksGrid(new String[]{"Math", "Sci", "Eng"});
        grid.addStudent("Anu",   new int[]{80, 90, 70});
        grid.addStudent("Ravi",  new int[]{60, 85});
        grid.addStudent("Meena", new int[]{95, 75, 88});

        System.out.println("Anu total:   " + grid.getTotal("Anu"));    // 240
        System.out.println("Ravi total:  " + grid.getTotal("Ravi"));   // 145
        System.out.println("Meena total: " + grid.getTotal("Meena")); // 258
        System.out.println("--- Toppers ---");
        grid.printToppers();
    }
}
