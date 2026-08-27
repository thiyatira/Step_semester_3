package oop.assigment_problems;

// intern subclass with stipend cap
public class InternEmployee extends Employee {
    private double stipendCap;

    public InternEmployee(String empId, String empName, double salary, double stipendCap) {
        super(empId, empName, salary);
        this.stipendCap = stipendCap;
    }

    public double getStipendCap() {
        return stipendCap;
    }

    // returns whichever is smaller: salary or stipendCap
    public double effectiveSalary() {
        return Math.min(getSalary(), stipendCap);
    }
}
