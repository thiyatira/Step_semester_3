package arrays.class_problems;

/**
 * Week 1 Practice - Problem 2: Palindrome Checker (3 Approaches)
 * Implements and verifies iterative, recursive, and array-reversal checks.
 */
public class PalindromeChecker {

    // Approach 1: Iterative two-pointer check
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Approach 2: Recursive check
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal check
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyText(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean arrRev = isPalindromeArrayReversal(text);

        String iterStr = iter ? "Palindrome" : "Not Palindrome";
        String recurStr = recur ? "Palindrome" : "Not Palindrome";
        String arrRevStr = arrRev ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", text);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n", iterStr, recurStr, arrRevStr);
    }

    public static void main(String[] args) {
        verifyText("madam");
        verifyText("hello");
        verifyText("racecar");
        verifyText("step");
    }
}
