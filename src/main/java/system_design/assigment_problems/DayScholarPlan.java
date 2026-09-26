package system_design.assigment_problems;

public class DayScholarPlan implements PricingPlan {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice;
    }

    @Override
    public String getPlanName() {
        return "Day Scholar";
    }
}
