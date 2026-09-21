package abstraction_interface.assigment_problems;

// WashingMachine extending HomeDevice and implementing both RemoteControllable and EnergyTrackable.
public class WashingMachine extends HomeDevice implements RemoteControllable, EnergyTrackable {
    private double consumptionWatts;

    public WashingMachine(double consumptionWatts) {
        super();
        if (consumptionWatts <= 0) {
            throw new IllegalArgumentException("Consumption watts must be positive.");
        }
        this.consumptionWatts = consumptionWatts;
    }

    @Override
    public String activate() {
        return "Washing machine " + getSerialNumber() + " started a cycle";
    }

    @Override
    public String connect(String appId) {
        return getSerialNumber() + " connected to " + appId;
    }

    @Override
    public double getConsumptionWatts() {
        return consumptionWatts;
    }
}
