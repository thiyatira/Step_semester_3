package system_design.assigment_problems;

public class StandardShipping implements ShippingType {
    @Override
    public double calculateCharge(double weightKg) {
        return 40.0 + (10.0 * weightKg);
    }

    @Override
    public String getName() {
        return "Standard";
    }
}
