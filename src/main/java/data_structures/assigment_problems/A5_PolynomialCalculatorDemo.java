package data_structures.assigment_problems;

// Demo: Polynomial Calculator — merging sorted term lists with coefficient summing.
public class A5_PolynomialCalculatorDemo {
    public static void main(String[] args) {
        PolynomialCalculator pc = new PolynomialCalculator();

        // Sample 1: 5x^3 + 4x^2 + 2  +  5x^2 - 3x + 1  =  5x^3 + 9x^2 - 3x + 3
        PolynomialCalculator.PolyNode p1 = poly(5, 3, 4, 2, 2, 0);
        PolynomialCalculator.PolyNode q1 = poly(5, 2, -3, 1, 1, 0);
        System.out.println(pc.toString(pc.addPolynomials(p1, q1)));

        // Sample 2: 3x^2 + 1  +  -3x^2 + 4x  =  4x + 1
        PolynomialCalculator.PolyNode p2 = poly(3, 2, 1, 0);
        PolynomialCalculator.PolyNode q2 = poly(-3, 2, 4, 1);
        System.out.println(pc.toString(pc.addPolynomials(p2, q2)));
    }

    private static PolynomialCalculator.PolyNode poly(int... cv) {
        PolynomialCalculator.PolyNode dummy = new PolynomialCalculator.PolyNode(0, -1);
        PolynomialCalculator.PolyNode cur   = dummy;
        for (int i = 0; i < cv.length; i += 2) {
            cur.next = new PolynomialCalculator.PolyNode(cv[i], cv[i + 1]);
            cur = cur.next;
        }
        return dummy.next;
    }
}
