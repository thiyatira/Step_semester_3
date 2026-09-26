package system_design.assigment_problems;

public class ExpressShipping implements ShippingType {
    @Override
    public double calculateCharge(double weightKg) {
        return 80.0 + (15.0 * weightKg);
    }

    @Override
    public String getName() {
        return "Express";
    }
}
