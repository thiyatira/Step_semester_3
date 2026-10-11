package data_structures.assigment_problems;

// Adds two polynomials stored as descending-exponent linked lists; zero-coefficient terms are omitted.
public class PolynomialCalculator {

    static class PolyNode {
        int coeff, exp;
        PolyNode next;
        PolyNode(int coeff, int exp) { this.coeff = coeff; this.exp = exp; }
    }

    public PolyNode addPolynomials(PolyNode p, PolyNode q) {
        PolyNode dummy = new PolyNode(0, -1);
        PolyNode tail  = dummy;

        while (p != null && q != null) {
            int coeff, exp;
            if (p.exp > q.exp) {
                coeff = p.coeff; exp = p.exp; p = p.next;
            } else if (q.exp > p.exp) {
                coeff = q.coeff; exp = q.exp; q = q.next;
            } else {
                coeff = p.coeff + q.coeff;
                exp   = p.exp;
                p     = p.next;
                q     = q.next;
            }
            if (coeff != 0) {
                tail.next = new PolyNode(coeff, exp);
                tail      = tail.next;
            }
        }
        while (p != null) { tail.next = new PolyNode(p.coeff, p.exp); tail = tail.next; p = p.next; }
        while (q != null) { tail.next = new PolyNode(q.coeff, q.exp); tail = tail.next; q = q.next; }
        return dummy.next;
    }

    public String toString(PolyNode head) {
        if (head == null) return "0";
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            int c = head.coeff;
            int e = head.exp;
            if (sb.length() > 0) sb.append(c > 0 ? " + " : " - ");
            else if (c < 0)      sb.append("-");
            int ac = Math.abs(c);
            if (e == 0)      sb.append(ac);
            else if (e == 1) sb.append(ac).append("x");
            else             sb.append(ac).append("x^").append(e);
            head = head.next;
        }
        return sb.toString();
    }
}
