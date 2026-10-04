package data_structures.class_problems;

import java.util.ArrayList;
import java.util.List;

// Executes range-bounded binary searches over pre-sorted library catalog records.
public class CatalogRangeQuery {
    public static List<String> findBooksInRange(BookRecord[] catalog, String lowerIsbn, String upperIsbn) {
        List<String> results = new ArrayList<>();
        if (catalog == null || catalog.length == 0 || lowerIsbn == null || upperIsbn == null) {
            return results;
        }

        int start = findLowerBound(catalog, lowerIsbn);
        int end = findUpperBound(catalog, upperIsbn);

        if (start <= end && start < catalog.length && end >= 0) {
            for (int i = start; i <= end; i++) {
                results.add(catalog[i].getTitle());
            }
        }
        return results;
    }

    private static int findLowerBound(BookRecord[] catalog, String lowerIsbn) {
        int low = 0;
        int high = catalog.length - 1;
        int ans = catalog.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (catalog[mid].getIsbn().compareTo(lowerIsbn) >= 0) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findUpperBound(BookRecord[] catalog, String upperIsbn) {
        int low = 0;
        int high = catalog.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (catalog[mid].getIsbn().compareTo(upperIsbn) <= 0) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
