package system_design.assigment_problems;

public class BrightnessCapability implements Capability {
    private int brightness = 0;

    @Override
    public String getCapabilityName() {
        return "Brightness";
    }

    @Override
    public boolean applyValue(Object value) {
        if (value instanceof Number) {
            int b = ((Number) value).intValue();
            if (b >= 0 && b <= 100) {
                this.brightness = b;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getValue() {
        return brightness;
    }
}
