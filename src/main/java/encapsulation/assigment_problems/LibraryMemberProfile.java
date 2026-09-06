package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 4: LibraryMemberProfile JavaBean
 * Supports chained constructors, JavaBean conventions, write-once ID, and write-only security answer.
 */
public class LibraryMemberProfile {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    @SuppressWarnings("unused")
    private String securityAnswer; // write-only field

    // 1. No-argument constructor
    public LibraryMemberProfile() {
        this(null, null);
    }

    // 2. Name-only constructor
    public LibraryMemberProfile(String name) {
        this(null, name);
    }

    // 3. ID + Name constructor (central target of chaining)
    public LibraryMemberProfile(String membershipId, String name) {
        this.membershipId = membershipId;
        this.name = name;
        this.premiumMember = false;
        this.securityAnswer = null;
    }

    public String getMembershipId() {
        return membershipId;
    }

    // Write-once property: only the first non-null write takes effect
    public void setMembershipId(String id) {
        if (this.membershipId == null && id != null && !id.trim().isEmpty()) {
            this.membershipId = id.trim();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only property: never retrievable via any getter
    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer;
    }
}
