package week12.assigment_problems;

// Demonstrates loop detection for cyclic and acyclic routes.
public class A1_DeliveryRouteDemo {
    public static void main(String[] args) {
        DeliveryRoute detector = new DeliveryRoute();
        DeliveryRoute.Node a = new DeliveryRoute.Node(10);
        a.next = new DeliveryRoute.Node(20);
        a.next.next = new DeliveryRoute.Node(30);
        a.next.next.next = new DeliveryRoute.Node(40);
        a.next.next.next.next = new DeliveryRoute.Node(50);
        a.next.next.next.next.next = a.next.next;
        System.out.println(detector.detectLoop(a));
        DeliveryRoute.Node b = new DeliveryRoute.Node(10);
        b.next = new DeliveryRoute.Node(20);
        b.next.next = new DeliveryRoute.Node(30);
        System.out.println(detector.detectLoop(b));
        DeliveryRoute.Node c = new DeliveryRoute.Node(7);
        c.next = c;
        System.out.println(detector.detectLoop(c));
    }
}
