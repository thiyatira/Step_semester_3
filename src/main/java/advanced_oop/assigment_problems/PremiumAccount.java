package advanced_oop.assigment_problems;

// subclass for premium students who get 50% discount on surge fees
public class PremiumAccount extends DeliveryAccount {

    public PremiumAccount(String studentId, double orderValue) {
        super(studentId, orderValue);
    }

    public PremiumAccount(String studentId) {
        super(studentId);
    }

    public double getDiscountedSurgeFee(int delayMinutes) {
        // 50% discount for premium
        return calculateSurgeFee(delayMinutes) * 0.5;
    }
}
