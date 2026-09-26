package system_design.class_problems;

public class LuxuryCar extends Vehicle {
    public LuxuryCar(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model, dailyRate);
    }

    @Override
    public double calculateRental(int days) {
        return dailyRate * days;
    }
}
