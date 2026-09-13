package inheritance_polymorphism.class_problems;

import java.util.Arrays;

// Demonstration of overridden late-fee penalties and defensive copy audit trails.
public class P3_LateRegistrationDemo {
    public static void main(String[] args) {
        WorkshopTicket w = new WorkshopTicket("STU2", 1200, "AI/ML");
        w.pay(1200);
        w.applyLateFee(100);
        System.out.println("Balance after late fee: " + w.getBalanceDue());

        double[] history = w.getLateFeeHistory();
        System.out.println("Retrieved history: " + Arrays.toString(history));

        history[0] = 999;
        System.out.println("History after external array mutation: " + Arrays.toString(w.getLateFeeHistory()));
    }
}
