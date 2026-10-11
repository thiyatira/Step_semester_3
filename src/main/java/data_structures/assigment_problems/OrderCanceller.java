package data_structures.assigment_problems;

// Removes the k-th node from the end of a singly linked list in a single pass.
public class OrderCanceller {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node lead = dummy;
        Node trail = dummy;

        for (int i = 0; i <= k; i++) {
            lead = lead.next;
        }
        while (lead != null) {
            lead  = lead.next;
            trail = trail.next;
        }
        trail.next = trail.next.next;
        return dummy.next;
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
