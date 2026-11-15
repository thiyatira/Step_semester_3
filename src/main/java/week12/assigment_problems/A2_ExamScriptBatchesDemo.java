package week12.assigment_problems;

// Demonstrates reversal of complete script batches.
public class A2_ExamScriptBatchesDemo {
    public static void main(String[] args) {
        ExamScriptBatches batches = new ExamScriptBatches();
        ExamScriptBatches.Node head = list(1, 2, 3, 4, 5, 6, 7, 8);
        print(batches.reverseInGroups(head, 3));
        print(batches.reverseInGroups(list(11, 12), 3));
    }

    private static ExamScriptBatches.Node list(int... values) {
        ExamScriptBatches.Node head = null;
        ExamScriptBatches.Node tail = null;
        for (int value : values) {
            ExamScriptBatches.Node node = new ExamScriptBatches.Node(value);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        return head;
    }

    private static void print(ExamScriptBatches.Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
