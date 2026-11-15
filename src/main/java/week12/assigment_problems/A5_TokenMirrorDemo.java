package week12.assigment_problems;

// Demonstrates palindrome checks and restoration of token chains.
public class A5_TokenMirrorDemo {
    public static void main(String[] args) {
        check(4, 7, 9, 7, 4);
        check(4, 7, 7, 9);
    }

    private static void check(int... values) {
        TokenMirror.Node head = null;
        TokenMirror.Node tail = null;
        for (int value : values) {
            TokenMirror.Node node = new TokenMirror.Node(value);
            if (head == null) head = node;
            else tail.next = node;
            tail = node;
        }
        System.out.println("Palindrome: " + new TokenMirror().isPalindrome(head));
        System.out.print("List after check: ");
        for (TokenMirror.Node node = head; node != null; node = node.next) {
            System.out.print(node.data + " -> ");
        }
        System.out.println("null");
    }
}
