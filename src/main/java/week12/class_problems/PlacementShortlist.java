package week12.class_problems;

import java.util.Arrays;

// Ranks candidates and answers cutoff and pair queries.
public class PlacementShortlist {
    private final Candidate[] candidates;

    public PlacementShortlist(Candidate[] candidates) {
        if (candidates == null || candidates.length < 1 || candidates.length > 100000) {
            throw new IllegalArgumentException("There must be between 1 and 100000 candidates");
        }
        this.candidates = Arrays.copyOf(candidates, candidates.length);
        for (Candidate candidate : this.candidates) {
            if (candidate == null) {
                throw new IllegalArgumentException("Candidates cannot be null");
            }
        }
        mergeSort(this.candidates, new Candidate[candidates.length], 0, candidates.length);
    }

    private static void mergeSort(Candidate[] values, Candidate[] buffer, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(values, buffer, start, middle);
        mergeSort(values, buffer, middle, end);
        int left = start;
        int right = middle;
        for (int i = start; i < end; i++) {
            if (right == end || (left < middle && values[left].total >= values[right].total)) {
                buffer[i] = values[left++];
            } else {
                buffer[i] = values[right++];
            }
        }
        System.arraycopy(buffer, start, values, start, end - start);
    }

    public Candidate[] getCandidates() {
        return Arrays.copyOf(candidates, candidates.length);
    }

    public int countAtLeast(int cutoff) {
        int low = 0;
        int high = candidates.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (candidates[middle].total >= cutoff) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public Candidate[] findPair(int target) {
        int left = 0;
        int right = candidates.length - 1;
        while (left < right) {
            int sum = candidates[left].total + candidates[right].total;
            if (sum == target) {
                return new Candidate[] {candidates[left], candidates[right]};
            }
            if (sum > target) {
                left++;
            } else {
                right--;
            }
        }
        return new Candidate[0];
    }

    // Holds a candidate's immutable scores and best interval.
    public static class Candidate {
        private final String name;
        private final int[] scores;
        private final int total;
        private final int gain;
        private final int startTest;
        private final int endTest;

        public Candidate(String name, int[] scores) {
            if (name == null || name.isBlank() || scores == null || scores.length != 6) {
                throw new IllegalArgumentException("A name and six scores are required");
            }
            this.name = name;
            this.scores = Arrays.copyOf(scores, scores.length);
            int sum = 0;
            for (int score : this.scores) {
                if (score < 0 || score > 100) {
                    throw new IllegalArgumentException("Scores must be between 0 and 100");
                }
                sum += score;
            }
            total = sum;
            int minimum = this.scores[0];
            int minimumIndex = 0;
            int best = Integer.MIN_VALUE;
            int bestStart = 0;
            int bestEnd = 1;
            for (int i = 1; i < this.scores.length; i++) {
                int difference = this.scores[i] - minimum;
                if (difference > best || (difference == best && minimumIndex < bestStart)) {
                    best = difference;
                    bestStart = minimumIndex;
                    bestEnd = i;
                }
                if (this.scores[i] < minimum) {
                    minimum = this.scores[i];
                    minimumIndex = i;
                }
            }
            gain = best;
            startTest = bestStart + 1;
            endTest = bestEnd + 1;
        }

        public String getName() { return name; }
        public int getTotal() { return total; }
        public int getGain() { return gain; }
        public int getStartTest() { return startTest; }
        public int getEndTest() { return endTest; }
        public int[] getScores() { return Arrays.copyOf(scores, scores.length); }
    }
}
