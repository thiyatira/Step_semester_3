package system_design.class_problems;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<LineItem> items;
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = "NEW";
        System.out.println("Order created.");
    }

    public void addItem(String itemName, double price, int quantity) {
        items.add(new LineItem(itemName, price, quantity));
        System.out.printf("Added %s (Qty %d).%n", itemName, quantity);
    }

    public boolean placeOrder(IPaymentMethod paymentMethod) {
        if (items.isEmpty()) {
            System.out.println("Cannot place order: Order must contain at least one item.");
            return false;
        }

        System.out.println("Order placed.");
        double total = 0;
        for (LineItem item : items) {
            total += item.getTotal();
        }

        boolean success = paymentMethod.processPayment(total);
        if (success) {
            this.status = "Paid";
            System.out.printf("Payment via %s successful. Order status: %s.%n", paymentMethod.getMethodName(), status);
            System.out.printf("Notification: Order #%s placed and paid.%n", orderId);
            return true;
        } else {
            this.status = "Pending Payment";
            System.out.printf("Payment via %s failed. Order status: %s.%n", paymentMethod.getMethodName(), status);
            System.out.printf("Notification: Order #%s placed, awaiting payment.%n", orderId);
            return false;
        }
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}
