package data_structures.assigment_problems;

// O(n) time, O(1) space palindrome check on a singly linked list with full restoration.
public class PalindromeTrain {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: find mid (slow stops at end of first half)
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse second half
        Node secondHalf = reverse(slow.next);
        Node copy = secondHalf;

        // Step 3: compare
        Node left = head;
        boolean isPalin = true;
        while (copy != null) {
            if (left.data != copy.data) { isPalin = false; break; }
            left = left.next;
            copy = copy.next;
        }

        // Step 4: restore second half
        slow.next = reverse(secondHalf);
        return isPalin;
    }

    private Node reverse(Node head) {
        Node prev = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next  = prev;
            prev      = cur;
            cur       = next;
        }
        return prev;
    }

    public static String listToString(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.data);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        return sb.toString();
    }
}
