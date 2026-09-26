package system_design.assigment_problems;

public interface Capability {
    String getCapabilityName();
    boolean applyValue(Object value);
    Object getValue();
}
