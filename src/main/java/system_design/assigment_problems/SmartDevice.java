package system_design.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SmartDevice {
    private String name;
    private Map<String, Capability> capabilities;

    public SmartDevice(String name) {
        this.name = name;
        this.capabilities = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addCapability(Capability capability) {
        capabilities.put(capability.getCapabilityName().toLowerCase(), capability);
    }

    public boolean hasCapability(String capabilityName) {
        return capabilities.containsKey(capabilityName.toLowerCase());
    }

    public Capability getCapability(String capabilityName) {
        return capabilities.get(capabilityName.toLowerCase());
    }

    public boolean executeAction(String capabilityName, Object value) {
        Capability cap = getCapability(capabilityName);
        if (cap == null) {
            return false;
        }
        if (capabilityName.equalsIgnoreCase("Temperature")) {
            if (value instanceof Number) {
                int t = ((Number) value).intValue();
                if (t < 16 || t > 30) {
                    System.out.printf("Rejected: %s temperature must be between 16\u00B0C and 30\u00B0C.%n", name);
                    return false;
                }
            }
        } else if (capabilityName.equalsIgnoreCase("Brightness")) {
            if (value instanceof Number) {
                int b = ((Number) value).intValue();
                if (b < 0 || b > 100) {
                    System.out.printf("Rejected: %s brightness must be between 0%% and 100%%.%n", name);
                    return false;
                }
            }
        }
        boolean ok = cap.applyValue(value);
        if (ok) {
            if (capabilityName.equalsIgnoreCase("Brightness")) {
                System.out.printf("%s: brightness set to %s%%.%n", name, cap.getValue());
            } else if (capabilityName.equalsIgnoreCase("Temperature")) {
                System.out.printf("%s: temperature set to %s\u00B0C.%n", name, cap.getValue());
            } else if (capabilityName.equalsIgnoreCase("Power")) {
                System.out.printf("%s: power set to %s.%n", name, cap.getValue());
            }
        }
        return ok;
    }
}
