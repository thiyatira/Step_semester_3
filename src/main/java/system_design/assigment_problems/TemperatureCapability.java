package system_design.assigment_problems;

public class TemperatureCapability implements Capability {
    private int temperature = 24;

    @Override
    public String getCapabilityName() {
        return "Temperature";
    }

    @Override
    public boolean applyValue(Object value) {
        if (value instanceof Number) {
            int t = ((Number) value).intValue();
            if (t >= 16 && t <= 30) {
                this.temperature = t;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getValue() {
        return temperature;
    }
}
