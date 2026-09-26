package system_design.assigment_problems;

public class PowerCapability implements Capability {
    private boolean on = false;

    @Override
    public String getCapabilityName() {
        return "Power";
    }

    @Override
    public boolean applyValue(Object value) {
        if (value instanceof Boolean) {
            this.on = (Boolean) value;
            return true;
        } else if (value instanceof String) {
            String s = ((String) value).trim().toLowerCase();
            if (s.equals("on") || s.equals("true")) {
                this.on = true;
                return true;
            } else if (s.equals("off") || s.equals("false")) {
                this.on = false;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getValue() {
        return on ? "ON" : "OFF";
    }
}
