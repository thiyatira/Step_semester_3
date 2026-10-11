package data_structures.class_problems;

// Binary search utilities to count products within a price range in a sorted array.
public class PriceFinder {

    public static int lowerBound(int[] prices, int target) {
        int lo = 0, hi = prices.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prices[mid] < target) lo = mid + 1;
            else                      hi = mid;
        }
        return lo;
    }

    public static int upperBound(int[] prices, int target) {
        int lo = 0, hi = prices.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prices[mid] <= target) lo = mid + 1;
            else                       hi = mid;
        }
        return lo;
    }

    public static int countInRange(int[] prices, int low, int high) {
        return upperBound(prices, high) - lowerBound(prices, low);
    }
}
