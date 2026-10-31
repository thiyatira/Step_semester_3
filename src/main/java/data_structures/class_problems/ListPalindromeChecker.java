package data_structures.class_problems;

// Checks whether a singly linked list is a palindrome using O(1) extra space.
public class ListPalindromeChecker {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        ListNode left = head;
        ListNode right = secondHalf;
        boolean same = true;
        while (right != null) {
            if (left.val != right.val) {
                same = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        slow.next = reverse(secondHalf);
        return same;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
