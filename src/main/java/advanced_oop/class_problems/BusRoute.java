package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 3: Bus Route Ranking Engine
 * Implements constructor chaining, custom compareTo with tie-breaking, and manual sorting.
 */
public class BusRoute implements Comparable<BusRoute> {
    private String routeCode;
    private String routeName;
    private int priority;

    public BusRoute(String routeCode, String routeName, int priority) {
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.priority = priority;
    }

    // 2-argument constructor chaining via this(...)
    public BusRoute(String routeCode, String routeName) {
        this(routeCode, routeName, 1); // default priority 1
    }

    public String getRouteCode() {
        return routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BusRoute other) {
        if (other == null) return -1;

        // 1. Higher priority first (descending)
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        }

        // 2. Case-insensitive route code
        int codeComparison = this.routeCode.compareToIgnoreCase(other.routeCode);
        if (codeComparison != 0) {
            return codeComparison;
        }

        // 3. Route name length
        return Integer.compare(this.routeName.length(), other.routeName.length());
    }

    // Manual sort (Insertion Sort) without calling Arrays.sort()
    public static BusRoute[] rankRoutes(BusRoute[] routes) {
        if (routes == null) return null;

        BusRoute[] sorted = routes.clone();
        for (int i = 1; i < sorted.length; i++) {
            BusRoute current = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].compareTo(current) > 0) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = current;
        }
        return sorted;
    }
}
