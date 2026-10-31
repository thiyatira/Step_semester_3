package data_structures.class_problems;

// Demo runner for alternate-from-ends list reordering.
public class P5_ListReordererDemo {
    public static void main(String[] args) {
        ListReorderer reorderer = new ListReorderer();

        ListNode even = ListNode.of(1, 2, 3, 4);
        reorderer.reorderList(even);
        System.out.println(ListNode.show(even));

        ListNode odd = ListNode.of(1, 2, 3, 4, 5);
        reorderer.reorderList(odd);
        System.out.println(ListNode.show(odd));

        ListNode two = ListNode.of(1, 2);
        reorderer.reorderList(two);
        System.out.println(ListNode.show(two));

        ListNode one = ListNode.of(1);
        reorderer.reorderList(one);
        System.out.println(ListNode.show(one));
    }
}
