package advanced_oop.class_problems;

// class problem 2: payment transaction with final method and static counter
final class PaymentTransaction {
    private static int counter = 0;

    private final String txnId;
    private final double amount;
    private final String mode;

    public PaymentTransaction(double amount, String mode) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        counter++;
        this.txnId = "TXN-" + (50000 + counter);
        this.amount = amount;
        this.mode = mode;
    }

    public final String getTxnId() {
        return txnId;
    }

    public final double getAmount() {
        return amount;
    }

    public final String getMode() {
        return mode;
    }

    public static int getTotalTransactions() {
        return counter;
    }
}

public class PaymentProcessorDemo {
    public static void main(String[] args) {
        PaymentTransaction t1 = new PaymentTransaction(1250.0, "UPI");
        PaymentTransaction t2 = new PaymentTransaction(450.0, "Card");

        System.out.println("Recorded " + t1.getTxnId() + " (" + t1.getMode() + ") : Rs " + t1.getAmount());
        System.out.println("Recorded " + t2.getTxnId() + " (" + t2.getMode() + ") : Rs " + t2.getAmount());
        System.out.println("Total transactions processed: " + PaymentTransaction.getTotalTransactions());
    }
}
