package abstraction_interface.assigment_problems;

// SquareShape extending Shape with side-based area calculation.
public class SquareShape extends Shape {
    private double side;

    public SquareShape(double side) {
        super();
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive.");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return (side * scaleX) * (side * scaleY);
    }

    public double getSide() {
        return side;
    }
}
