package system_design.assigment_problems;

public interface PricingPlan {
    double applyDiscount(double basePrice);
    String getPlanName();
}
