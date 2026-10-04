package data_structures.assigment_problems;

// Counts students scoring within a specified mark band using dual binary search boundaries.
public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerIndex = findFirstGreaterOrEqual(scores, low);
        int upperIndex = findFirstStrictlyGreater(scores, high);

        return upperIndex - lowerIndex;
    }

    private static int findFirstGreaterOrEqual(int[] scores, int target) {
        int l = 0;
        int r = scores.length - 1;
        int ans = scores.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (scores[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private static int findFirstStrictlyGreater(int[] scores, int target) {
        int l = 0;
        int r = scores.length - 1;
        int ans = scores.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (scores[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
