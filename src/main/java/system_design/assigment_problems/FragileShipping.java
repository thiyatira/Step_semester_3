package system_design.assigment_problems;

public class FragileShipping implements ShippingType {
    private StandardShipping standard = new StandardShipping();

    @Override
    public double calculateCharge(double weightKg) {
        return standard.calculateCharge(weightKg) + 50.0;
    }

    @Override
    public String getName() {
        return "Fragile";
    }
}
