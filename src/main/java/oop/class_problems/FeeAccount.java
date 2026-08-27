package oop.class_problems;

/**
 * Week 3 Practice - Problem F2: Base FeeAccount
 * Manages tuition/fee payments with private fields and balance calculation.
 */
public class FeeAccount {
    private String regNo;
    private double totalFee;
    private double amountPaid;

    public FeeAccount(String regNo, double totalFee, double amountPaid) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    public String getRegNo() {
        return regNo;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Payment rejected: amount must be positive.");
            return;
        }
        this.amountPaid += amount;
    }

    public double getDue() {
        double due = totalFee - amountPaid;
        return due > 0 ? due : 0.0;
    }
}
