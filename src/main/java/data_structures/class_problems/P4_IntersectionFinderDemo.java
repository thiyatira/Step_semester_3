package data_structures.class_problems;

// Demo runner for finding the intersection node of two lists.
public class P4_IntersectionFinderDemo {
    public static void main(String[] args) {
        IntersectionFinder finder = new IntersectionFinder();

        ListNode shared = ListNode.of(8, 4, 5);
        ListNode a = ListNode.of(4, 1);
        a.next.next = shared;
        ListNode b = ListNode.of(5, 6, 1);
        b.next.next.next = shared;

        ListNode hit = finder.findIntersection(a, b);
        System.out.println(hit == null ? "null" : "Node with value " + hit.val);

        ListNode miss = finder.findIntersection(ListNode.of(2, 6, 4), ListNode.of(1, 5));
        System.out.println(miss == null ? "null" : "Node with value " + miss.val);
    }
}
