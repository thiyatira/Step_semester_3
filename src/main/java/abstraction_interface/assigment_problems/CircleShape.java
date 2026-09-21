package abstraction_interface.assigment_problems;

// CircleShape extending Shape with radius-based area calculation.
public class CircleShape extends Shape {
    private double radius;

    public CircleShape(double radius) {
        super();
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * (radius * scaleX) * (radius * scaleY);
    }

    public double getRadius() {
        return radius;
    }
}
