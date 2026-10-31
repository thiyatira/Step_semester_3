package data_structures.class_problems;

// Removes the n-th node from the end of a singly linked list in a single pass.
public class NthNodeRemover {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be at least 1");
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
            if (fast == null) {
                throw new IllegalArgumentException("n is larger than the list length");
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
