package arrays.assigment_problems;

import java.util.Locale;

// Question 2: Typing speed accuracy checker
public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if(original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int total = original.length();
        int minLen = Math.min(original.length(), typed.length());
        int matched = 0;
        int mismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        // checking character by character
        for(int i = 0; i < minLen; i++) {
            if(original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if(mismatchPos == -1) {
                // 1-based indexing for position
                mismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        // if length mismatch and no earlier error
        if(mismatchPos == -1 && original.length() != typed.length()) {
            mismatchPos = minLen + 1;
            origChar = (original.length() > typed.length()) ? original.charAt(minLen) : ' ';
            typedChar = (typed.length() > original.length()) ? typed.charAt(minLen) : ' ';
        }

        double accuracy = total == 0 ? 100.0 : ((double) matched / total) * 100.0;

        if(mismatchPos != -1) {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, mismatchPos, origChar, typedChar);
        } else {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest Case 2:");
        checkTypingAccuracy("coding", "coding");
    }
}
