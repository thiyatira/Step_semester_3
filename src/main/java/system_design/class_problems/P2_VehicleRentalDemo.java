package system_design.class_problems;

public class P2_VehicleRentalDemo {
    public static void main(String[] args) {
        RentalService service = new RentalService();

        Vehicle luxuryCar = new LuxuryCar("V1", "Luxury Car A", 100.0);
        Vehicle standardCar = new StandardCar("V2", "Standard Car B", 50.0);

        service.rentVehicle("Alice", luxuryCar, 3);
        service.rentVehicle("Bob", standardCar, 5);

        service.rentVehicle("Charlie", luxuryCar, 2);

        service.returnVehicle(luxuryCar);
    }
}
