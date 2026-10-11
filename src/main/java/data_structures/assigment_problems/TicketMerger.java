package data_structures.assigment_problems;

// Merges two sorted singly linked lists by relinking nodes — no new nodes created.
public class TicketMerger {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public Node mergeSorted(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail  = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) { tail.next = a; a = a.next; }
            else                  { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
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
