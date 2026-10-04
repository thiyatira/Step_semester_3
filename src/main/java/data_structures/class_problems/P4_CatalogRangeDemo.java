package data_structures.class_problems;

import java.util.List;

// Tests bounded ISBN range retrieval on pre-sorted book records using binary search.
public class P4_CatalogRangeDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 4: Range-Bounded Catalog Query Demo ===");
        BookRecord[] catalog = {
            new BookRecord("0001112223", "Introduction to Algebra"),
            new BookRecord("0002223334", "Beginning Python"),
            new BookRecord("0003334445", "Classic Mythology"),
            new BookRecord("0004445556", "Data and Society"),
            new BookRecord("0005556667", "European History")
        };

        String low1 = "0002000000";
        String high1 = "0004500000";
        List<String> range1 = CatalogRangeQuery.findBooksInRange(catalog, low1, high1);
        System.out.println("Range [" + low1 + " to " + high1 + "]:");
        System.out.println("Expected: [Beginning Python, Classic Mythology, Data and Society]");
        System.out.println("Actual  : " + range1);

        String low2 = "0008000000";
        String high2 = "0009000000";
        List<String> range2 = CatalogRangeQuery.findBooksInRange(catalog, low2, high2);
        System.out.println("\nRange [" + low2 + " to " + high2 + "]:");
        System.out.println("Expected: []");
        System.out.println("Actual  : " + range2);
    }
}
