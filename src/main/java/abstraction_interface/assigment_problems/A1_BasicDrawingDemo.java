package abstraction_interface.assigment_problems;

// Demonstration of abstract Shape class, subclasses, and overloaded scale methods.
public class A1_BasicDrawingDemo {
    public static void main(String[] args) {
        CircleShape c = new CircleShape(5.0);
        System.out.printf("Circle area: %.2f%n", c.calculateArea());

        SquareShape sq = new SquareShape(4.0);
        System.out.println("Square initial area: " + sq.calculateArea());

        // Single-argument scale overload
        sq.scale(2.0);
        System.out.println("Square scaled area (factor 2.0): " + sq.calculateArea());

        // Polymorphic printArea using Shape reference
        Shape.printArea(c);
    }
}
