package system_design.class_problems;

public abstract class Vehicle {
    protected String vehicleId;
    protected String model;
    protected double dailyRate;
    protected boolean available;

    public Vehicle(String vehicleId, String model, double dailyRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    public abstract double calculateRental(int days);

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}
