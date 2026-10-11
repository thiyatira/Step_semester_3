package data_structures.class_problems;

// Abstract library resource identified by a unique string ID.
public abstract class Resource {
    private final String id;

    public Resource(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Resource ID must not be blank.");
        this.id = id;
    }

    public String getId() { return id; }
}
