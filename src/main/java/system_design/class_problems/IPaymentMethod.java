package system_design.class_problems;

public interface IPaymentMethod {
    boolean processPayment(double amount);
    String getMethodName();
}
