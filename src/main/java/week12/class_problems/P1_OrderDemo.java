package week12.class_problems;

// Demonstrates an order cursor and its nested item type.
public class P1_OrderDemo {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Order.LineItem("Pen", 3, 10));
        order.addItem(new Order.LineItem("Book", 2, 250));
        order.addItem(new Order.LineItem("Bag", 1, 700));
        Order.Cursor cursor = order.new Cursor();
        while (cursor.hasNext()) {
            Order.LineItem item = cursor.next();
            System.out.printf("%s %.0f%n", item.getProductName(), item.total());
        }
        System.out.printf("Total %.0f%n", order.total());
        System.out.println("cursor: inner (reads the order's array)");
        System.out.println("line item: static nested (needs no order)");
    }
}
