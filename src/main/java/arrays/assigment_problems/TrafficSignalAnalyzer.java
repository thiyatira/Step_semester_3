package arrays.assigment_problems;

// Question 3: Traffic Signal Streak Analyzer
// scans string and finds longest streak of same signal color
public class TrafficSignalAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if(signalLog == null || signalLog.length() == 0) {
            System.out.println("Empty signal log.");
            return;
        }

        char bestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currColor = signalLog.charAt(0);
        int currStreak = 1;

        for(int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if(c == currColor) {
                currStreak++;
            } else {
                // streak ended, check if its the longest so far
                if(currStreak > maxStreak) {
                    maxStreak = currStreak;
                    bestColor = currColor;
                }
                currColor = c;
                currStreak = 1;
            }
        }

        // check last streak after loop finishes
        if(currStreak > maxStreak) {
            maxStreak = currStreak;
            bestColor = currColor;
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1 (\"RRGGGYRR\"):");
        findLongestStreak("RRGGGYRR");

        System.out.println("\nTest Case 2 (\"RRRRYYGG\"):");
        findLongestStreak("RRRRYYGG");
    }
}
