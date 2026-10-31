package data_structures.class_problems;

// Demo runner for adding two numbers held in linked lists.
public class P3_ListAdderDemo {
    public static void main(String[] args) {
        ListAdder adder = new ListAdder();

        ListNode sum1 = adder.addNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4));
        System.out.println("342 + 465 = " + ListNode.show(sum1));

        ListNode sum2 = adder.addNumbers(ListNode.of(9, 9), ListNode.of(1));
        System.out.println("99 + 1 = " + ListNode.show(sum2));

        ListNode sum3 = adder.addNumbers(ListNode.of(0), ListNode.of(0));
        System.out.println("0 + 0 = " + ListNode.show(sum3));
    }
}
