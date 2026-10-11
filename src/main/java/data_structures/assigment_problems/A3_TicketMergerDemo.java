package data_structures.assigment_problems;

// Demo: Merging Two Ticket Counters — in-place sorted linked list merge.
public class A3_TicketMergerDemo {
    public static void main(String[] args) {
        TicketMerger tm = new TicketMerger();

        // Sample 1
        TicketMerger.Node a1 = build(3, 8, 15);
        TicketMerger.Node b1 = build(5, 8, 12, 20);
        System.out.println(TicketMerger.listToString(tm.mergeSorted(a1, b1)));
        // 3->5->8->8->12->15->20

        // Sample 2: empty + singleton
        TicketMerger.Node b2 = build(4);
        System.out.println(TicketMerger.listToString(tm.mergeSorted(null, b2)));
        // 4
    }

    private static TicketMerger.Node build(int... vals) {
        TicketMerger.Node dummy = new TicketMerger.Node(0);
        TicketMerger.Node cur   = dummy;
        for (int v : vals) { cur.next = new TicketMerger.Node(v); cur = cur.next; }
        return dummy.next;
    }
}
