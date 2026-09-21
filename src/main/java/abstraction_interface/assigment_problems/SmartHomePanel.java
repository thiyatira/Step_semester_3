package abstraction_interface.assigment_problems;

// Panel coordinator connecting all RemoteControllable items polymorphically.
public class SmartHomePanel {
    public static void connectAll(RemoteControllable[] items, String appId) {
        if (items == null) return;
        for (RemoteControllable item : items) {
            if (item != null) {
                System.out.println(item.connect(appId));
            }
        }
    }
}
