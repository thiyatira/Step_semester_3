package abstraction_interface.assigment_problems;

// Abstract base class representing a home appliance with unique serial number tracking.
public abstract class HomeDevice {
    private static int deviceCounter = 0;
    private final String serialNumber;

    public HomeDevice() {
        deviceCounter++;
        this.serialNumber = "HD-" + (1000 + deviceCounter);
    }

    public abstract String activate();

    public String getSerialNumber() {
        return serialNumber;
    }

    // Safely retrieves power consumption if the device implements EnergyTrackable
    public static double getConsumptionIfTrackable(HomeDevice d) {
        if (d instanceof EnergyTrackable) {
            EnergyTrackable et = (EnergyTrackable) d;
            return et.getConsumptionWatts();
        }
        return -1.0;
    }
}
