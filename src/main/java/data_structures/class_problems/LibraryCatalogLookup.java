package data_structures.class_problems;

// Performs logarithmic lookup for book titles by ISBN over pre-sorted catalog records.
public class LibraryCatalogLookup {
    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null || catalog.length == 0) {
            return "Not Found";
        }
        int low = 0;
        int high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].getIsbn().compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid].getTitle();
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }
}
