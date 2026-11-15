package week12.class_problems;

import java.util.NoSuchElementException;

// Stores order items and provides a cursor over them.
public class Order {
    private final LineItem[] items = new LineItem[100];
    private int size;

    public void addItem(LineItem item) {
        if (item == null || size == items.length) {
            throw new IllegalArgumentException("An item is required and the order can hold at most 100 items");
        }
        items[size++] = item;
    }

    public double total() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += items[i].total();
        }
        return sum;
    }

    // Represents a line item without requiring an order instance.
    public static class LineItem {
        private final String productName;
        private final int quantity;
        private final double unitPrice;

        public LineItem(String productName, int quantity, double unitPrice) {
            if (productName == null || productName.isBlank() || quantity < 1 || quantity > 1000
                    || !Double.isFinite(unitPrice) || unitPrice < 0) {
                throw new IllegalArgumentException("Invalid product name, quantity, or unit price");
            }
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getProductName() {
            return productName;
        }

        public double total() {
            return quantity * unitPrice;
        }
    }

    // Walks the items of its enclosing order.
    public class Cursor {
        private int index;

        public boolean hasNext() {
            return index < size;
        }

        public LineItem next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more line items");
            }
            return items[index++];
        }

        public void reset() {
            index = 0;
        }
    }
}
