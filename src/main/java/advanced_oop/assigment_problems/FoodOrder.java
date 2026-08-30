package advanced_oop.assigment_problems;

// Question 1: Ghost Order Validator
// no default constructor, validates studentName and dishName
public class FoodOrder {
    private String studentName;
    private String dishName;
    private boolean delivered;

    public FoodOrder(String studentName, String dishName) {
        // check null or whitespace only
        if(studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        if(dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be empty.");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDishName() {
        return dishName;
    }

    public boolean isDelivered() {
        return delivered;
    }

    // prints alert if called a second time
    public void markDelivered() {
        if(!delivered) {
            delivered = true;
            System.out.println("Order for " + studentName + " (" + dishName + ") marked as delivered.");
        } else {
            System.out.println("ALERT: Order for " + studentName + " (" + dishName + ") was already marked delivered! Double-serve detected.");
        }
    }

    // batch processor counting valid and rejected orders
    public static void processBatch(String[][] rawOrders) {
        if(rawOrders == null) {
            System.out.println("Valid: 0 | Rejected: 0");
            return;
        }

        int valid = 0;
        int rejected = 0;

        for(String[] order : rawOrders) {
            if(order == null || order.length < 2) {
                rejected++;
                continue;
            }
            try {
                new FoodOrder(order[0], order[1]);
                valid++;
            } catch(IllegalArgumentException e) {
                rejected++;
            }
        }

        System.out.printf("Valid: %d | Rejected: %d%n", valid, rejected);
    }
}
