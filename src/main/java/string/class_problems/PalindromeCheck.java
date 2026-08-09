package string.class_problems;

// class problem 2: checking palindrome with two pointers
public class PalindromeCheck {

    public static boolean isPalindrome(String s) {
        if(s == null) return false;
        int left = 0;
        int right = s.length() - 1;

        // move pointers inward from both sides
        while(left < right) {
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "madam";
        String word2 = "hello";

        System.out.println(word1 + " is palindrome? " + isPalindrome(word1));
        System.out.println(word2 + " is palindrome? " + isPalindrome(word2));
    }
}
