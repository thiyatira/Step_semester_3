package week12.assigment_problems;

// Demonstrates stable sorting of returned books.
public class A4_LibraryReturnsDemo {
    public static void main(String[] args) {
        LibraryReturns.Node head = new LibraryReturns.Node("Java", 15);
        head.next = new LibraryReturns.Node("DSA", 3);
        head.next.next = new LibraryReturns.Node("OS", 9);
        head.next.next.next = new LibraryReturns.Node("DBMS", 3);
        head.next.next.next.next = new LibraryReturns.Node("CN", 12);
        head.next.next.next.next.next = new LibraryReturns.Node("AI", 1);
        LibraryReturns sorter = new LibraryReturns();
        print(sorter.sortByDueDay(head));
        print(sorter.sortByDueDay(null));
    }

    private static void print(LibraryReturns.Node node) {
        while (node != null) {
            System.out.print(node.title + ":" + node.dueDay + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
