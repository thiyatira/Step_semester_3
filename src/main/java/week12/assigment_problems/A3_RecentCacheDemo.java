package week12.assigment_problems;

// Demonstrates page access, updates, and cache eviction.
public class A3_RecentCacheDemo {
    public static void main(String[] args) {
        RecentCache cache = new RecentCache(2);
        put(cache, 1, "Home");
        put(cache, 2, "Notes");
        get(cache, 1);
        put(cache, 3, "Quiz");
        get(cache, 2);
        put(cache, 1, "Home2");
        put(cache, 4, "Mail");
        get(cache, 3);
        get(cache, 1);
        System.out.println("Cache (most recent first): " + cache.describe());
    }

    private static void put(RecentCache cache, int key, String page) {
        cache.put(key, page);
        String result = "put(" + key + "," + page + ")";
        if (cache.getLastEvictedKey() != null) result += " evicted " + cache.getLastEvictedKey();
        else if (cache.wasLastPutUpdated()) result += " updated";
        System.out.println(result);
    }

    private static void get(RecentCache cache, int key) {
        System.out.println("get(" + key + ") -> " + cache.get(key));
    }
}
