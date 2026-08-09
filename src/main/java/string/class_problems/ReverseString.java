package string.class_problems;

// class problem 1: reversing strings
public class ReverseString {

    // method 1: using stringbuilder built-in reverse
    public static String reverseWithStringBuilder(String input) {
        if(input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    // method 2: using normal for loop backwards
    public static String reverseWithLoop(String input) {
        if(input == null) return null;
        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "BridgeLabz";
        System.out.println("Original: " + original);
        System.out.println("Reversed (StringBuilder): " + reverseWithStringBuilder(original));
        System.out.println("Reversed (Loop): " + reverseWithLoop(original));
    }
}
