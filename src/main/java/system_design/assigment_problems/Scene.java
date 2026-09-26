package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    public static class SceneAction {
        String capabilityName;
        Object value;

        public SceneAction(String capabilityName, Object value) {
            this.capabilityName = capabilityName;
            this.value = value;
        }
    }

    private String sceneName;
    private List<SceneAction> actions;

    public Scene(String sceneName) {
        this.sceneName = sceneName;
        this.actions = new ArrayList<>();
    }

    public void addAction(String capabilityName, Object value) {
        actions.add(new SceneAction(capabilityName, value));
    }

    public int applyTo(List<SmartDevice> devices) {
        int appliedCount = 0;
        for (SmartDevice device : devices) {
            for (SceneAction action : actions) {
                if (device.hasCapability(action.capabilityName)) {
                    boolean success = device.executeAction(action.capabilityName, action.value);
                    if (success) {
                        appliedCount++;
                    }
                }
            }
        }
        System.out.printf("Scene '%s' completed: %d actions applied.%n", sceneName, appliedCount);
        return appliedCount;
    }

    public String getSceneName() {
        return sceneName;
    }
}
