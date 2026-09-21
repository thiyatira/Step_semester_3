package abstraction_interface.class_problems;

// DigitalPass implementing Renewable directly without extending LibraryItem.
public class DigitalPass implements Renewable {
    private String resourceName;

    public DigitalPass(String resourceName) {
        if (resourceName == null || resourceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Resource name cannot be blank.");
        }
        this.resourceName = resourceName.trim();
    }

    @Override
    public String renew() {
        return resourceName + " renewed";
    }

    public String getResourceName() {
        return resourceName;
    }
}
