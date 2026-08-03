package arrays.class_problems;

/**
 * Week 1 Practice - Problem 4: First Non-Repeating Character
 * Finds the first character that appears exactly once in the input string.
 */
public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Compute frequency of every character using an ASCII frequency array
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequency[ch]++;
            }
        }

        // Scan string from left to right to find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // None found
    }

    public static void displayResult(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\"%n", text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        displayResult("swiss");
        displayResult("aabbcc");
        displayResult("step semester");
    }
}
