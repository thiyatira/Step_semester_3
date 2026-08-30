package advanced_oop.assigment_problems;

// testing ghost order validator
public class P1_GhostOrderValidator {
    public static void main(String[] args) {
        String[][] rawOrders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", " "},
            {"Divya", "Veg Biryani"}
        };

        System.out.println("Processing raw batch orders:");
        FoodOrder.processBatch(rawOrders);

        System.out.println("\nTesting markDelivered behavior:");
        FoodOrder order = new FoodOrder("Kunal", "Dosa");
        order.markDelivered();
        order.markDelivered(); // second time alert
    }
}
