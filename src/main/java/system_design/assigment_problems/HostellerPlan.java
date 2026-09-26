package system_design.assigment_problems;

public class HostellerPlan implements PricingPlan {
    @Override
    public double applyDiscount(double basePrice) {
        return basePrice * 0.90;
    }

    @Override
    public String getPlanName() {
        return "Hosteller";
    }
}
