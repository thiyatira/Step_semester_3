package inheritance_polymorphism.assigment_problems;

import java.util.Arrays;

// Demonstration of late-fee penalty override and tamper-proof defensive copy history.
public class A3_LateWithdrawalDemo {
    public static void main(String[] args) {
        RunnerEntry r = new RunnerEntry("BIB2001", 80, "Open 10K");
        r.pay(30);
        r.applyLateFee(20);
        System.out.println("Balance due: " + r.getBalanceDue());

        double[] history = r.getLateFeeHistory();
        System.out.println("Recorded history: " + Arrays.toString(history));

        history[0] = 999;
        System.out.println("History after external array modification: " + Arrays.toString(r.getLateFeeHistory()));
    }
}
