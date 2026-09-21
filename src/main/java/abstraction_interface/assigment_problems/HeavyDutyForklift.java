package abstraction_interface.assigment_problems;

// HeavyDutyForklift extending Forklift (multilevel inheritance) and reusing super.performMaintenance().
public class HeavyDutyForklift extends Forklift {

    public HeavyDutyForklift(String assetTag) {
        super(assetTag);
    }

    @Override
    public String performMaintenance() {
        return super.performMaintenance() + " | high-pressure hydraulic check complete";
    }
}
