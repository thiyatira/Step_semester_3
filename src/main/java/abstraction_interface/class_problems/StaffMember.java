package abstraction_interface.class_problems;

// Abstract class for staff members with encapsulated salary and chained constructors.
public abstract class StaffMember {
    private double baseSalary;
    protected double bonusRate;

    // Chained constructor defaulting bonusRate to 0.10
    public StaffMember(double baseSalary) {
        this(baseSalary, 0.10);
    }

    public StaffMember(double baseSalary, double bonusRate) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
    }

    public abstract double calculateBonus();

    public double getSalary() {
        return baseSalary;
    }

    public void setSalary(double baseSalary) {
        if (baseSalary < 0) {
            System.out.println("rejected, salary unchanged");
            return;
        }
        this.baseSalary = baseSalary;
    }

    public double getBonusRate() {
        return bonusRate;
    }

    // Static helper checking if staff member implements Auditable capability
    public static String getAuditIfApplicable(StaffMember s) {
        if (s instanceof Auditable) {
            Auditable a = (Auditable) s;
            return a.auditRecord();
        }
        return "No audit required";
    }
}
