package abstraction_interface.class_problems;

// Multilevel hierarchy: DualZoneMotionSensor extends MotionSensor and reuses super.sendAlert().
public class DualZoneMotionSensor extends MotionSensor {
    private String secondZoneName;

    public DualZoneMotionSensor(String zoneName, String secondZoneName) {
        super(zoneName);
        if (secondZoneName == null || secondZoneName.trim().isEmpty()) {
            throw new IllegalArgumentException("Second zone name cannot be blank.");
        }
        this.secondZoneName = secondZoneName.trim();
    }

    @Override
    public String sendAlert(String message) {
        return super.sendAlert(message) + " [also covering " + secondZoneName + "]";
    }

    public String getSecondZoneName() {
        return secondZoneName;
    }
}
