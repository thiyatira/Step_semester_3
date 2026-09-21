package abstraction_interface.assigment_problems;

// Non-character arena entity implementing only Defendable with no character ancestry.
public class Trap implements Defendable {
    private String trapType;

    public Trap(String trapType) {
        if (trapType == null || trapType.trim().isEmpty()) {
            throw new IllegalArgumentException("Trap type cannot be blank.");
        }
        this.trapType = trapType.trim();
    }

    @Override
    public String defend() {
        return trapType + " triggers automatically";
    }

    public String getTrapType() {
        return trapType;
    }
}
