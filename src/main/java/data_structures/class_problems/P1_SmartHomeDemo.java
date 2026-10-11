package data_structures.class_problems;

// Demo: Smart Home Platform — capability-based device command dispatch.
public class P1_SmartHomeDemo {
    public static void main(String[] args) {
        SmartHomeSystem hub = new SmartHomeSystem();
        hub.addDevice(new Light("L1"));
        hub.addDevice(new Fan("F1"));
        hub.addDevice(new Plug("P1", 12));

        hub.executeCommand("ON L1");
        hub.executeCommand("DIM L1 40");
        hub.executeCommand("DIM F1 30");
        hub.executeCommand("SCHEDULE F1 22:00");
        hub.executeCommand("ENERGY P1");
        hub.executeCommand("ENERGY L1");
    }
}
