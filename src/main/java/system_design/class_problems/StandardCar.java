package system_design.class_problems;

public class StandardCar extends Vehicle {
    public StandardCar(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model, dailyRate);
    }

    @Override
    public double calculateRental(int days) {
        return dailyRate * days;
    }
}
