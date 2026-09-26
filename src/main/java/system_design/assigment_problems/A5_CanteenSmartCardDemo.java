package system_design.assigment_problems;

public class A5_CanteenSmartCardDemo {
    public static void main(String[] args) {
        SmartCard card = new SmartCard("C-2045", new HostellerPlan());

        card.topUp(500);
        card.purchase("Veg Thali", 120);
        card.refund("Veg Thali");
        card.refund("Veg Thali");

        System.out.println();
        System.out.println(card.getMiniStatement());
    }
}
