package week12.assigment_problems;

// Checks a token chain and restores every link afterward.
public class TokenMirror {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverse(slow.next);
        Node left = head;
        Node right = secondHalf;
        boolean palindrome = true;
        while (right != null) {
            if (left.data != right.data) {
                palindrome = false;
            }
            left = left.next;
            right = right.next;
        }
        slow.next = reverse(secondHalf);
        return palindrome;
    }

    private Node reverse(Node head) {
        Node previous = null;
        while (head != null) {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    // Represents a token in the chain.
    public static class Node {
        public final int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
