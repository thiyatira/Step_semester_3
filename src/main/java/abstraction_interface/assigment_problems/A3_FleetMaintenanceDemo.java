package abstraction_interface.assigment_problems;

// Demonstration of ServiceableVehicle abstract class, multilevel hierarchy, Insurable interface, and safe casting.
public class A3_FleetMaintenanceDemo {
    public static void main(String[] args) {
        Forklift f = new Forklift("FL-22");
        f.addMileage(120);
        System.out.println("Forklift Mileage: " + f.getMileage());
        System.out.println(f.performMaintenance());

        // Negative mileage rejection test
        f.addMileage(-50);

        HeavyDutyForklift hd = new HeavyDutyForklift("HD-9");
        System.out.println(hd.performMaintenance());

        // Safe downcasting check for Insurable
        System.out.println(ServiceableVehicle.getInsuranceIfApplicable(f));
        System.out.println(ServiceableVehicle.getInsuranceIfApplicable(hd));
    }
}
