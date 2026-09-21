package abstraction_interface.class_problems;

// Interface defining capability for devices capable of raising alerts.
public interface Alertable {
    String sendAlert(String message);
}
