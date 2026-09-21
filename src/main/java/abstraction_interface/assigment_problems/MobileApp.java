package abstraction_interface.assigment_problems;

// Independent mobile controller implementing RemoteControllable with no HomeDevice relation.
public class MobileApp implements RemoteControllable {
    private String appName;

    public MobileApp(String appName) {
        if (appName == null || appName.trim().isEmpty()) {
            throw new IllegalArgumentException("App name cannot be blank.");
        }
        this.appName = appName.trim();
    }

    @Override
    public String connect(String appId) {
        return appName + " connected to " + appId;
    }

    public String getAppName() {
        return appName;
    }
}
