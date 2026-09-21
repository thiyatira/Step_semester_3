package abstraction_interface.assigment_problems;

// Demonstration of HomeDevice hierarchy, multiple interfaces, selective implementation, and RemoteControllable batch connections.
public class A5_ConnectedHomeDemo {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine(500.0);
        System.out.println(wm.activate());
        System.out.println(wm.connect("HomeConnect"));

        Refrigerator fridge = new Refrigerator(150.0);
        System.out.println("Refrigerator consumption: " + HomeDevice.getConsumptionIfTrackable(fridge) + "W");

        MobileApp app = new MobileApp("HomeConnect App");
        System.out.println(app.connect("HomeConnect"));

        // Upcasting: WashingMachine stored as HomeDevice
        HomeDevice ref = wm;
        System.out.println("Trackable consumption via HomeDevice reference: " + HomeDevice.getConsumptionIfTrackable(ref) + "W");

        // Batch polymorphic connect
        RemoteControllable[] remotes = {wm, app};
        SmartHomePanel.connectAll(remotes, "HomeConnect");
    }
}
