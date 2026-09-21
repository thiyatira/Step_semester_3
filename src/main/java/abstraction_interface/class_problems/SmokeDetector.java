package abstraction_interface.class_problems;

// Independent device implementing Alertable directly without extending SecuritySensor.
public class SmokeDetector implements Alertable {
    private String deviceId;

    public SmokeDetector(String deviceId) {
        if (deviceId == null || deviceId.trim().isEmpty()) {
            throw new IllegalArgumentException("Device ID cannot be blank.");
        }
        this.deviceId = deviceId.trim();
    }

    @Override
    public String sendAlert(String message) {
        return "[" + deviceId + "] " + message;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
