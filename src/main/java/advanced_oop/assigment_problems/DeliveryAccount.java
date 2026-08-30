package advanced_oop.assigment_problems;

// Question 5: Delivery Account with static block and constructor chaining
public class DeliveryAccount {
    protected static double baseRate;

    // static block for 1-time setup
    static {
        baseRate = 0.05;
    }

    private String studentId;
    private double orderValue;

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = (studentId != null) ? studentId.trim() : "UNKNOWN";
        this.orderValue = Math.max(0.0, orderValue);
    }

    // provisional constructor chaining via this(...)
    public DeliveryAccount(String studentId) {
        this(studentId, 0.0);
    }

    public String getStudentId() {
        return studentId;
    }

    public double getOrderValue() {
        return orderValue;
    }

    // final method computing surge fee using tiered brackets
    public final double calculateSurgeFee(int delayMinutes) {
        if(delayMinutes <= 0 || orderValue <= 0) {
            return 0.0;
        }

        double percent = 0.0;
        int b1 = Math.min(delayMinutes, 5);
        percent += b1 * 0.5;

        if(delayMinutes > 5) {
            int b2 = Math.min(delayMinutes - 5, 10);
            percent += b2 * 1.0;
        }

        if(delayMinutes > 15) {
            int b3 = delayMinutes - 15;
            percent += b3 * 2.0;
        }

        return (percent / 100.0) * orderValue;
    }
}
