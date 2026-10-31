package data_structures.class_problems;

// Demo runner for the linked list palindrome check.
public class P2_ListPalindromeDemo {
    public static void main(String[] args) {
        ListPalindromeChecker checker = new ListPalindromeChecker();

        ListNode even = ListNode.of(1, 2, 2, 1);
        System.out.println(ListNode.show(even) + " -> " + checker.isPalindrome(even));

        ListNode notPal = ListNode.of(1, 2, 3);
        System.out.println(ListNode.show(notPal) + " -> " + checker.isPalindrome(notPal));

        ListNode odd = ListNode.of(1, 2, 3, 2, 1);
        System.out.println(ListNode.show(odd) + " -> " + checker.isPalindrome(odd));
        System.out.println("list after check : " + ListNode.show(odd));

        System.out.println(ListNode.show(null) + " -> " + checker.isPalindrome(null));
    }
}
