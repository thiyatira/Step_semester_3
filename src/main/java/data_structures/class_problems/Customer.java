package data_structures.class_problems;

import java.util.Objects;

// Immutable customer value object with content equality on ID and name.
public class Customer {
    private final int id;
    private final String name;

    public Customer(int id, String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Customer name must not be blank.");
        this.id   = id;
        this.name = name;
    }

    public int    getId()   { return id; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer c)) return false;
        return id == c.id && name.equals(c.name);
    }

    @Override
    public int hashCode() { return Objects.hash(id, name); }

    @Override
    public String toString() { return "Customer(" + id + ", " + name + ")"; }
}
