package abstraction_interface.class_problems;

// CreditCardPayment specialization of PaymentMethod.
public class CreditCardPayment extends PaymentMethod {
    private String cardNumberLastFour;

    public CreditCardPayment(String cardNumberLastFour) {
        super();
        this.cardNumberLastFour = cardNumberLastFour;
    }

    @Override
    public String processPayment(double amount) {
        return "Charged $" + amount + " to card ending " + cardNumberLastFour + " - Txn " + getTransactionId();
    }

    public String getCardNumberLastFour() {
        return cardNumberLastFour;
    }
}
