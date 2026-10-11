package data_structures.class_problems;

// Demo: Customer Registry — hashCode/equals contract for deduplication.
public class P2_CustomerRegistryDemo {
    public static void main(String[] args) {
        CustomerRegistry registry = new CustomerRegistry();

        System.out.println(registry.addCustomer(new Customer(101, "Asha")));   // true
        System.out.println(registry.addCustomer(new Customer(101, "Asha")));   // false
        System.out.println(registry.addCustomer(new Customer(102, "Ravi")));   // true
        System.out.println(registry.contains(new Customer(101, "Asha")));      // true
        System.out.println("Unique count: " + registry.uniqueCount());         // 2
    }
}
