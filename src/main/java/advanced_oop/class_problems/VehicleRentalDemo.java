package advanced_oop.class_problems;

// class problem 1: vehicle rental with constructor chaining and inheritance
class Vehicle {
    private String regNo;
    private String brand;
    private double dailyRate;

    public Vehicle(String regNo, String brand, double dailyRate) {
        if(regNo == null || regNo.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
        this.regNo = regNo.trim().toUpperCase();
        this.brand = brand;
        this.dailyRate = dailyRate;
    }

    // constructor chaining using this(...)
    public Vehicle(String regNo, String brand) {
        this(regNo, brand, 1000.0);
    }

    public String getRegNo() {
        return regNo;
    }

    public String getBrand() {
        return brand;
    }

    public double calculateRental(int days) {
        return dailyRate * days;
    }
}

class LuxuryCar extends Vehicle {
    private double luxuryFee;

    public LuxuryCar(String regNo, String brand, double dailyRate, double luxuryFee) {
        super(regNo, brand, dailyRate);
        this.luxuryFee = luxuryFee;
    }

    @Override
    public double calculateRental(int days) {
        return super.calculateRental(days) + luxuryFee;
    }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        Vehicle standard = new Vehicle("KA01AB1234", "Toyota");
        LuxuryCar luxury = new LuxuryCar("DL01CD5678", "Mercedes-Benz", 3500.0, 1500.0);

        System.out.println("Standard car 3-day rental: Rs " + standard.calculateRental(3));
        System.out.println("Luxury car 3-day rental: Rs " + luxury.calculateRental(3));
    }
}
