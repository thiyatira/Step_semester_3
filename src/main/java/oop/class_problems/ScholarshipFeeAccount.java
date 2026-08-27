package oop.class_problems;

/**
 * Week 3 Practice - Problem F2: ScholarshipFeeAccount Subclass
 * Extends FeeAccount with scholarship percentage reduction on outstanding due.
 */
public class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;

    public ScholarshipFeeAccount(String regNo, double totalFee, double amountPaid, double scholarshipPercent) {
        super(regNo, totalFee, amountPaid);
        this.scholarshipPercent = (scholarshipPercent < 0) ? 0 : (scholarshipPercent > 100 ? 100 : scholarshipPercent);
    }

    public double getScholarshipPercent() {
        return scholarshipPercent;
    }

    public double effectiveDue() {
        double rawDue = getDue();
        return rawDue * (1.0 - (scholarshipPercent / 100.0));
    }
}
