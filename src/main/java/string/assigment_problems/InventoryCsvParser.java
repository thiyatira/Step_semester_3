package string.assigment_problems;

// Question 3: CSV inventory record parser
public class InventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        if(csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] parts = csvLine.split(",");
        // must have exactly 3 parts: name, sku, qty
        if(parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = parts[0].trim();
        String sku = parts[1].trim();
        String qty = parts[2].trim();

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", name, sku, qty);
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1 (\"Wireless Mouse,WM-2201,150\"):");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");

        System.out.println("\nTest Case 2 (\"Wireless Mouse,150\"):");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
