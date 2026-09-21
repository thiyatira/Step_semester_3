package abstraction_interface.assigment_problems;

// Abstract Shape base class with auto-assigned shapeId and overloaded scale() methods.
public abstract class Shape {
    private static int shapeCounter = 0;
    private final String shapeId;

    protected double scaleX = 1.0;
    protected double scaleY = 1.0;

    public Shape() {
        shapeCounter++;
        this.shapeId = "SHP-" + (1000 + shapeCounter);
    }

    public abstract double calculateArea();

    // Equal scaling overload
    public void scale(double factor) {
        scale(factor, factor);
    }

    // Unequal scaling overload
    public void scale(double xFactor, double yFactor) {
        if (xFactor <= 0 || yFactor <= 0) {
            throw new IllegalArgumentException("Scale factors must be positive.");
        }
        this.scaleX *= xFactor;
        this.scaleY *= yFactor;
    }

    public String getShapeId() {
        return shapeId;
    }

    public static void printArea(Shape s) {
        if (s != null) {
            System.out.printf("%.2f%n", s.calculateArea());
        }
    }
}
