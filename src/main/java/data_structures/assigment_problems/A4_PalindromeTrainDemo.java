package data_structures.assigment_problems;

// Demo: Palindrome Train Code — O(n)/O(1) check with list restoration.
public class A4_PalindromeTrainDemo {
    public static void main(String[] args) {
        PalindromeTrain pt = new PalindromeTrain();

        PalindromeTrain.Node l1 = build(1, 2, 3, 2, 1);
        System.out.println(pt.isPalindrome(l1));                      // true
        System.out.println("Restored: " + PalindromeTrain.listToString(l1)); // 1->2->3->2->1

        PalindromeTrain.Node l2 = build(1, 2, 3, 2);
        System.out.println(pt.isPalindrome(l2));                      // false

        PalindromeTrain.Node l3 = build(1, 2, 2, 1);
        System.out.println(pt.isPalindrome(l3));                      // true
        System.out.println("Restored: " + PalindromeTrain.listToString(l3)); // 1->2->2->1
    }

    private static PalindromeTrain.Node build(int... vals) {
        PalindromeTrain.Node dummy = new PalindromeTrain.Node(0);
        PalindromeTrain.Node cur   = dummy;
        for (int v : vals) { cur.next = new PalindromeTrain.Node(v); cur = cur.next; }
        return dummy.next;
    }
}
