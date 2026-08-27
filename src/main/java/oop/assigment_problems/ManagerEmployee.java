package oop.assigment_problems;

// manager subclass with extra team bonus
public class ManagerEmployee extends Employee {
    private double teamBonus;

    public ManagerEmployee(String empId, String empName, double salary, double teamBonus) {
        super(empId, empName, salary);
        this.teamBonus = teamBonus;
    }

    public double getTeamBonus() {
        return teamBonus;
    }

    public double effectiveSalary() {
        return getSalary() + teamBonus;
    }
}
