package data_structures.assigment_problems;

// Demo runner for the bus bay ring buffer.
public class A4_BusBayDemo {
    public static void main(String[] args) {
        BusBay bay = new BusBay(3);

        System.out.println("insertLast(101)  -> " + bay.insertLast(101));
        System.out.println("insertLast(102)  -> " + bay.insertLast(102));
        System.out.println("insertFront(100) -> " + bay.insertFront(100));
        System.out.println("insertFront(99)  -> " + bay.insertFront(99));
        System.out.println("getRear()        -> " + bay.getRear());
        System.out.println("isFull()         -> " + bay.isFull());
        System.out.println("deleteLast()     -> " + bay.deleteLast());
        System.out.println("insertFront(98)  -> " + bay.insertFront(98));
        System.out.println("getFront()       -> " + bay.getFront());

        BusBay empty = new BusBay(2);
        System.out.println("empty deleteFront -> " + empty.deleteFront());
        System.out.println("empty getFront    -> " + empty.getFront());
        System.out.println("empty getRear     -> " + empty.getRear());
    }
}
