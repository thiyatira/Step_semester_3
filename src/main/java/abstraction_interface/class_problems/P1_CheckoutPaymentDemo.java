package abstraction_interface.class_problems;

// Demonstration of abstract PaymentMethod, subclasses, overloading, and polymorphic upcasting.
public class P1_CheckoutPaymentDemo {
    public static void main(String[] args) {
        // Problem 1 Examples
        CreditCardPayment cc = new CreditCardPayment("4471");
        System.out.println(cc.processPayment(250.0));

        CashPayment cash = new CashPayment();
        System.out.println(cash.processPayment(40.0));

        // Overloaded two-argument method
        System.out.println(cc.processPayment(250.0, "Birthday gift"));

        // Upcasting: storing a CreditCardPayment in a PaymentMethod-typed variable
        PaymentMethod ref = cc;
        PaymentMethod.printConfirmation(ref, 250.0);
    }
}
