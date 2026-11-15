package week12.assigment_problems;

// Detects a route loop, its entry point, and its length.
public class DeliveryRoute {
    public String detectLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 1;
                for (Node current = slow.next; current != slow; current = current.next) {
                    length++;
                }
                Node entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return "Loop: yes, starts at stop " + entry.data + ", length " + length;
            }
        }
        return "Loop: no";
    }

    // Represents a stop in a delivery route.
    public static class Node {
        public final int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
