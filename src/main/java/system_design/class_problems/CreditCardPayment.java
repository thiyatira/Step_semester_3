package system_design.class_problems;

public class CreditCardPayment implements IPaymentMethod {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }
}
