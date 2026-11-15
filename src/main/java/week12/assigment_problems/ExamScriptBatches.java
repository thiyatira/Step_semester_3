package week12.assigment_problems;

// Reverses complete batches of linked exam scripts in place.
public class ExamScriptBatches {
    public Node reverseInGroups(Node head, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("Batch size must be positive");
        }
        Node current = head;
        Node previousTail = null;
        Node result = head;
        while (current != null) {
            Node end = current;
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            Node after = end.next;
            Node previous = after;
            Node node = current;
            while (node != after) {
                Node next = node.next;
                node.next = previous;
                previous = node;
                node = next;
            }
            if (previousTail == null) {
                result = end;
            } else {
                previousTail.next = end;
            }
            previousTail = current;
            current = after;
        }
        return result;
    }

    // Represents an exam script in the chain.
    public static class Node {
        public final int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
