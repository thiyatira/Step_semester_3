package data_structures.class_problems;

import java.util.HashMap;
import java.util.Map;

// Command processor for a smart home that dispatches to device capabilities.
public class SmartHomeSystem {
    private final Map<String, Device> devices = new HashMap<>();

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
    }

    public void executeCommand(String command) {
        String[] parts = command.trim().split("\\s+");
        String cmd = parts[0];
        String id  = parts[1];
        Device device = devices.get(id);
        if (device == null) { System.out.println(id + " not found"); return; }

        switch (cmd) {
            case "ON" -> device.turnOn();
            case "DIM" -> {
                if (device instanceof Dimmable d) d.dim(Integer.parseInt(parts[2]));
                else System.out.println(id + " rejected: DIM unsupported");
            }
            case "SCHEDULE" -> {
                if (device instanceof Schedulable s) s.schedule(parts[2]);
                else System.out.println(id + " rejected: SCHEDULE unsupported");
            }
            case "ENERGY" -> {
                if (device instanceof EnergyMonitorable e)
                    System.out.printf("%s energy %.0f kWh%n", id, e.getEnergyUsage());
                else System.out.println(id + " rejected: ENERGY unsupported");
            }
            default -> System.out.println("Unknown command: " + cmd);
        }
    }
}
