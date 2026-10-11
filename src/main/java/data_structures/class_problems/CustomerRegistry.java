package data_structures.class_problems;

import java.util.HashSet;
import java.util.Set;

// Registry that enforces uniqueness of customers across branches using hashing.
public class CustomerRegistry {
    private final Set<Customer> registry = new HashSet<>();

    public boolean addCustomer(Customer c) {
        return registry.add(c);
    }

    public boolean contains(Customer c) {
        return registry.contains(c);
    }

    public int uniqueCount() {
        return registry.size();
    }
}
