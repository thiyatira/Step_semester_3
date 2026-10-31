package data_structures.class_problems;

// Demo runner for removing the n-th node from the end.
public class P1_NthNodeRemoverDemo {
    public static void main(String[] args) {
        NthNodeRemover remover = new NthNodeRemover();

        ListNode first = ListNode.of(1, 2, 3, 4, 5);
        System.out.println("n = 2 : " + ListNode.show(remover.removeNthFromEnd(first, 2)));

        ListNode single = ListNode.of(1);
        System.out.println("n = 1 : " + ListNode.show(remover.removeNthFromEnd(single, 1)));

        ListNode headCase = ListNode.of(7, 8, 9);
        System.out.println("n = 3 : " + ListNode.show(remover.removeNthFromEnd(headCase, 3)));

        try {
            remover.removeNthFromEnd(ListNode.of(1, 2), 5);
        } catch (IllegalArgumentException e) {
            System.out.println("n = 5 : " + e.getMessage());
        }
    }
}
