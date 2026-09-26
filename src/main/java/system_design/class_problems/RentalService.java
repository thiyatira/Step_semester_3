package system_design.class_problems;

public class RentalService {
    public void rentVehicle(String customerName, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.printf("Rental failed: %s is currently unavailable.%n", vehicle.getModel());
            return;
        }
        vehicle.setAvailable(false);
        double charge = vehicle.calculateRental(days);
        System.out.printf("%s rented for %d days. Total charge: $%.2f%n", vehicle.getModel(), days, charge);
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
        System.out.printf("%s returned. Now available.%n", vehicle.getModel());
    }
}
