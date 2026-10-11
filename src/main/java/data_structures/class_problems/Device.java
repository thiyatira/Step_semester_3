package data_structures.class_problems;

// Abstract base device with an ID and on/off state for the smart home system.
public abstract class Device {
    private final String id;
    private boolean on;

    public Device(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Device ID must not be blank.");
        this.id = id;
    }

    public String getId() { return id; }

    public void turnOn() {
        on = true;
        System.out.println(id + " is ON");
    }

    public boolean isOn() { return on; }
}
