package abstraction_interface.class_problems;

// Concrete base class representing a security sensor installed in a specific zone.
public class SecuritySensor {
    protected String zoneName;

    public SecuritySensor(String zoneName) {
        if (zoneName == null || zoneName.trim().isEmpty()) {
            throw new IllegalArgumentException("Zone name cannot be blank.");
        }
        this.zoneName = zoneName.trim();
    }

    public String getZoneName() {
        return zoneName;
    }

    // Static polymorphic broadcast over an Alertable interface array
    public static void broadcastAll(Alertable[] devices, String message) {
        if (devices == null) return;
        for (Alertable device : devices) {
            if (device != null) {
                System.out.println(device.sendAlert(message));
            }
        }
    }

    // Safe downcasting using instanceof to retrieve zone name if the device is a MotionSensor
    public static String getZoneIfMotionSensor(Alertable a) {
        if (a instanceof MotionSensor) {
            MotionSensor ms = (MotionSensor) a;
            return ms.getZoneName();
        }
        return "Not a motion sensor";
    }
}
