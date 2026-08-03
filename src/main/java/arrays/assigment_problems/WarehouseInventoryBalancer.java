package arrays.assigment_problems;

// Question 4: Warehouse Inventory Balancer
public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if(sectionA == null || sectionB == null) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int sumA = 0;
        int sumB = 0;
        int maxQty = -1;
        String bestSection = "Section A";
        int bestIndex = 1;

        // check section A items
        for(int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            if(sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                bestSection = "Section A";
                bestIndex = i + 1; // 1-based index
            }
        }

        // check section B items
        for(int i = 0; i < sectionB.length; i++) {
            sumB += sectionB[i];
            if(sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                bestSection = "Section B";
                bestIndex = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                sumA, sumB, status, maxQty, bestSection, bestIndex);
    }

    public static void main(String[] args) {
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};

        System.out.println("Test Case 1 ({20,15,30} vs {25,10,30}):");
        analyzeInventory(secA, secB);
    }
}
