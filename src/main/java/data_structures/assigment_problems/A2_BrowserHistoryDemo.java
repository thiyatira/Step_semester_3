package data_structures.assigment_problems;

// Demo: Campus Portal Browser History — doubly linked list navigation.
public class A2_BrowserHistoryDemo {
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory("srm.edu");
        bh.visit("a.com");
        bh.visit("b.com");
        bh.visit("c.com");

        System.out.println(bh.back(1));    // b.com
        System.out.println(bh.back(1));    // a.com
        System.out.println(bh.forward(1)); // b.com
        bh.visit("d.com");                 // forward history cleared
        System.out.println(bh.forward(2)); // d.com (at end)
        System.out.println(bh.back(2));    // a.com
        System.out.println(bh.back(7));    // srm.edu (stops at start)
    }
}
