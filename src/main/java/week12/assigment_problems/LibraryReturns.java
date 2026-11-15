package week12.assigment_problems;

// Stably sorts linked book returns by due day.
public class LibraryReturns {
    public Node sortByDueDay(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right = slow.next;
        slow.next = null;
        return merge(sortByDueDay(head), sortByDueDay(right));
    }

    private Node merge(Node left, Node right) {
        Node head = null;
        Node tail = null;
        while (left != null || right != null) {
            Node selected;
            if (right == null || (left != null && left.dueDay <= right.dueDay)) {
                selected = left;
                left = left.next;
            } else {
                selected = right;
                right = right.next;
            }
            if (head == null) head = selected;
            else tail.next = selected;
            tail = selected;
        }
        return head;
    }

    // Represents a returned book and its due day.
    public static class Node {
        public final String title;
        public final int dueDay;
        public Node next;

        public Node(String title, int dueDay) {
            if (title == null || title.isBlank() || dueDay < 1 || dueDay > 365) {
                throw new IllegalArgumentException("A title and due day from 1 to 365 are required");
            }
            this.title = title;
            this.dueDay = dueDay;
        }
    }
}
