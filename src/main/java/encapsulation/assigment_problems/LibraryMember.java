package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 1: LibraryMember
 * Encapsulates library member data with field visibility modifiers and constructor validation.
 */
public class LibraryMember {
    // 1. private: sensitive ID should not be exposed directly
    private String membershipId;

    // 2. protected: branch information reachable by specialized subclass units
    protected String branchCode;

    // 3. package-private (default): fines accessed within local library circulation package
    double finesOwed;

    // 4. public: display name accessible anywhere
    public String displayName;

    // No default/no-argument constructor provided
    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null || membershipId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid membershipId: must be at least 4 non-whitespace characters.");
        }
        this.membershipId = membershipId.trim();
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public double getFinesOwed() {
        return finesOwed;
    }

    public String getDisplayName() {
        return displayName;
    }
}
