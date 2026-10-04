package data_structures.class_problems;

// Runs exact ISBN search verification using binary search on pre-sorted library catalog.
public class P3_LibraryLookupDemo {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Library Catalog Lookup Demo ===");
        BookRecord[] catalog = {
            new BookRecord("0001112223", "Introduction to Algebra"),
            new BookRecord("0002223334", "Beginning Python"),
            new BookRecord("0003334445", "Classic Mythology"),
            new BookRecord("0004445556", "Data and Society"),
            new BookRecord("0005556667", "European History")
        };

        String query1 = "0003334445";
        System.out.println("Query ISBN: " + query1);
        System.out.println("Expected: Classic Mythology");
        System.out.println("Actual  : " + LibraryCatalogLookup.findBook(catalog, query1));

        String query2 = "0009998887";
        System.out.println("\nQuery ISBN: " + query2);
        System.out.println("Expected: Not Found");
        System.out.println("Actual  : " + LibraryCatalogLookup.findBook(catalog, query2));
    }
}
