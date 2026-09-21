package abstraction_interface.class_problems;

// TeamLead subclass extending StaffMember and implementing Auditable.
public class TeamLead extends StaffMember implements Auditable {
    private int teamSize;

    public TeamLead(double baseSalary, int teamSize) {
        super(baseSalary);
        this.teamSize = teamSize;
    }

    public TeamLead(double baseSalary, double bonusRate, int teamSize) {
        super(baseSalary, bonusRate);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * getBonusRate();
    }

    @Override
    public String auditRecord() {
        return "TeamLead audit: " + teamSize + " team members, salary $" + getSalary();
    }

    public int getTeamSize() {
        return teamSize;
    }
}
