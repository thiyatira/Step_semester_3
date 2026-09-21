package abstraction_interface.assigment_problems;

// Abstract base class representing a fleet vehicle with encapsulated mileage tracking.
public abstract class ServiceableVehicle {
    private double mileage;

    public ServiceableVehicle() {
        this.mileage = 0.0;
    }

    public abstract String performMaintenance();

    public double getMileage() {
        return mileage;
    }

    public void addMileage(double km) {
        if (km < 0) {
            System.out.println("rejected, distance cannot be negative");
            return;
        }
        this.mileage += km;
    }

    // Static helper safely casting to Insurable capability via instanceof
    public static String getInsuranceIfApplicable(ServiceableVehicle v) {
        if (v instanceof Insurable) {
            Insurable ins = (Insurable) v;
            return ins.getInsuranceInfo();
        }
        return "No insurance record exists";
    }
}
