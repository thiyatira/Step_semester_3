package system_design.class_problems;

public class P5_FoodOrderDemo {
    public static void main(String[] args) {
        Order order1 = new Order("123");
        order1.addItem("Pizza", 12.0, 2);
        order1.addItem("Soda", 3.0, 1);

        Order emptyOrder = new Order("999");
        emptyOrder.placeOrder(new CreditCardPayment("1234-5678"));

        order1.placeOrder(new CreditCardPayment("1234-5678"));

        Order order2 = new Order("124");
        order2.addItem("Burger", 8.0, 1);
        order2.placeOrder(new DigitalWalletPayment("W-01", false));
    }
}
