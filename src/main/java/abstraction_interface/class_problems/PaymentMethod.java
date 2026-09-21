package abstraction_interface.class_problems;

// Abstract base class representing a payment method with an auto-generated transaction ID.
public abstract class PaymentMethod {
    private static int transactionCounter = 0;
    public final String transactionId;

    public PaymentMethod() {
        transactionCounter++;
        this.transactionId = "TXN-" + (1000 + transactionCounter);
    }

    public abstract String processPayment(double amount);

    // Overloaded method providing compile-time polymorphism
    public String processPayment(double amount, String note) {
        return processPayment(amount) + " (" + note + ")";
    }

    public String getTransactionId() {
        return transactionId;
    }

    public static void printConfirmation(PaymentMethod payment, double amount) {
        if (payment != null) {
            System.out.println(payment.processPayment(amount));
        }
    }
}
