package abstraction_interface.class_problems;

// MotionSensor extending SecuritySensor and implementing Alertable interface.
public class MotionSensor extends SecuritySensor implements Alertable {

    public MotionSensor(String zoneName) {
        super(zoneName);
    }

    @Override
    public String sendAlert(String message) {
        return "[" + getZoneName() + "] " + message;
    }
}
