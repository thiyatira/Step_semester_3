package data_structures.class_problems;

// Demo: Product Price Finder — binary search lower/upper bounds on sorted prices.
public class P4_PriceFinderDemo {
    public static void main(String[] args) {
        int[] prices = {100, 150, 150, 200, 300, 450};

        System.out.println("Lower bound (150): " + PriceFinder.lowerBound(prices, 150)); // 1
        System.out.println("Upper bound (300): " + PriceFinder.upperBound(prices, 300)); // 5
        System.out.println("Count in 150-300:  " + PriceFinder.countInRange(prices, 150, 300)); // 4
    }
}
