package oop.class_problems;

/**
 * Week 3 Practice - Problem F2: HostelFeeAccount Subclass
 * Extends FeeAccount with support for two-installment payments.
 */
public class HostelFeeAccount extends FeeAccount {

    public HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }

    public void payInTwoInstallments(double amount) {
        if (amount <= 0) {
            System.out.println("Installment rejected: amount must be positive.");
            return;
        }
        double installment = amount / 2.0;
        pay(installment);
        pay(installment);
    }
}
