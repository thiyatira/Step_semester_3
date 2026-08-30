package advanced_oop.assigment_problems;

// Question 3: Canteen Trust-Score Ranking Engine
// sorts canteens by trust score descending, ties broken by code case-insensitive
public class Canteen implements Comparable<Canteen> {
    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = (canteenCode != null) ? canteenCode.trim() : "";
        this.canteenName = (canteenName != null) ? canteenName.trim() : "";
        this.trustScore = trustScore;
    }

    // chained constructor defaulting trustScore to 3
    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    public String getCanteenCode() {
        return canteenCode;
    }

    public String getCanteenName() {
        return canteenName;
    }

    public int getTrustScore() {
        return trustScore;
    }

    @Override
    public int compareTo(Canteen other) {
        if(other == null) return -1;

        // 1. higher trust score first
        if(this.trustScore != other.trustScore) {
            return Integer.compare(other.trustScore, this.trustScore);
        }

        // 2. tiebreak: canteen code case-insensitive ascending
        int codeCmp = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if(codeCmp != 0) {
            return codeCmp;
        }

        // 3. tertiary tiebreak: name
        return this.canteenName.compareTo(other.canteenName);
    }

    // manual sort (insertion sort) without Arrays.sort
    public static Canteen[] rankCanteens(Canteen[] canteens) {
        if(canteens == null) return new Canteen[0];
        Canteen[] arr = canteens.clone();

        for(int i = 1; i < arr.length; i++) {
            Canteen key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] != null && (key == null || arr[j].compareTo(key) > 0)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        return arr;
    }
}
