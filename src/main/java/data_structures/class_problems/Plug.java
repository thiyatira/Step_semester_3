package data_structures.class_problems;

// Smart plug that reports energy consumption in kWh.
public class Plug extends Device implements EnergyMonitorable {
    private final double energyKwh;

    public Plug(String id, double energyKwh) {
        super(id);
        this.energyKwh = energyKwh;
    }

    @Override
    public double getEnergyUsage() { return energyKwh; }
}
