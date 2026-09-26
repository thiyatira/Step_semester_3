package system_design.assigment_problems;

public class StaffPlan implements PricingPlan {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice * 0.80;
    }

    @Override
    public String getPlanName() {
        return "Staff";
    }
}
