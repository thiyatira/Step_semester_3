package abstraction_interface.assigment_problems;

// Forklift extending ServiceableVehicle and implementing Insurable.
public class Forklift extends ServiceableVehicle implements Insurable {
    protected String assetTag;

    public Forklift(String assetTag) {
        super();
        if (assetTag == null || assetTag.trim().isEmpty()) {
            throw new IllegalArgumentException("Asset tag cannot be blank.");
        }
        this.assetTag = assetTag.trim();
    }

    @Override
    public String performMaintenance() {
        return "Forklift " + assetTag + ": hydraulic and fork inspection complete";
    }

    @Override
    public String getInsuranceInfo() {
        return "Insured under fleet policy - Asset " + assetTag;
    }

    public String getAssetTag() {
        return assetTag;
    }
}
