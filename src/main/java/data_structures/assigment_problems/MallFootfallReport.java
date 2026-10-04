package data_structures.assigment_problems;

// Evaluates high-volume range queries on hourly footfall using prefix sum precomputations.
public class MallFootfallReport {
    public static int[] footfallReport(int[] visitors, int[][] queries) {
        if (visitors == null || visitors.length == 0 || queries == null || queries.length == 0) {
            return new int[0];
        }

        int n = visitors.length;
        int[] prefix = new int[n];
        prefix[0] = visitors[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + visitors[i];
        }

        int[] results = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int start = queries[q][0];
            int end = queries[q][1];
            if (start < 0 || end >= n || start > end) {
                throw new IllegalArgumentException("Invalid query range: [" + start + ", " + end + "]");
            }
            results[q] = prefix[end] - (start > 0 ? prefix[start - 1] : 0);
        }
        return results;
    }
}
