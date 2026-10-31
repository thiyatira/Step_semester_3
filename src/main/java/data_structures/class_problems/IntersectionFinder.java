package data_structures.class_problems;

// Finds the first node shared by two singly linked lists by comparing node references.
public class IntersectionFinder {

    public ListNode findIntersection(ListNode a, ListNode b) {
        int lenA = length(a);
        int lenB = length(b);

        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }
        while (lenB > lenA) {
            b = b.next;
            lenB--;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
