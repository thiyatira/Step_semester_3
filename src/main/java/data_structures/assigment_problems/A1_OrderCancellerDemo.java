package data_structures.assigment_problems;

// Demo: Cancelling the k-th Last Order — single-pass two-pointer removal.
public class A1_OrderCancellerDemo {
    public static void main(String[] args) {
        OrderCanceller oc = new OrderCanceller();

        // Sample 1: remove 2nd from end (40) → 10->20->30->50
        OrderCanceller.Node head1 = build(10, 20, 30, 40, 50);
        System.out.println(OrderCanceller.listToString(oc.removeKthFromEnd(head1, 2)));

        // Sample 2: remove 5th from end (head=10) → 20->30->40->50
        OrderCanceller.Node head2 = build(10, 20, 30, 40, 50);
        System.out.println(OrderCanceller.listToString(oc.removeKthFromEnd(head2, 5)));
    }

    private static OrderCanceller.Node build(int... vals) {
        OrderCanceller.Node dummy = new OrderCanceller.Node(0);
        OrderCanceller.Node cur  = dummy;
        for (int v : vals) { cur.next = new OrderCanceller.Node(v); cur = cur.next; }
        return dummy.next;
    }
}
