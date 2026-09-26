package system_design.assigment_problems;

public interface ShippingType {
    double calculateCharge(double weightKg);
    String getName();
}
