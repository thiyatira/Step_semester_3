package abstraction_interface.class_problems;

// Demonstration of Alertable interface, multilevel sensor hierarchy, independent smoke detector, and safe downcasting.
public class P2_HomeSafetyAlertDemo {
    public static void main(String[] args) {
        MotionSensor m = new MotionSensor("Living Room");
        System.out.println(m.sendAlert("Motion detected"));

        DualZoneMotionSensor d = new DualZoneMotionSensor("Hallway", "Stairwell");
        System.out.println(d.sendAlert("Motion detected"));

        SmokeDetector s = new SmokeDetector("SD-01");
        System.out.println(s.sendAlert("Smoke detected"));

        // Safe downcasting checks
        System.out.println(SecuritySensor.getZoneIfMotionSensor(m));
        System.out.println(SecuritySensor.getZoneIfMotionSensor(s));

        // Polymorphic broadcast over an Alertable array
        Alertable[] devices = {m, d, s};
        SecuritySensor.broadcastAll(devices, "System Check OK");
    }
}
