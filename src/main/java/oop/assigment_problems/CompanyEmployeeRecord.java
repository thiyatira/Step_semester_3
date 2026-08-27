package oop.assigment_problems;

// Capstone: CompanyEmployeeRecord combines employee and parking slot
public class CompanyEmployeeRecord {
    public static int totalRecords = 0;

    private String name;
    private String empId;
    private Employee employee;
    private ParkingSlot slot;

    public CompanyEmployeeRecord(String name, String empId, Employee employee, ParkingSlot slot) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        this.slot = slot;
        totalRecords++;
    }

    public String fullProfile() {
        double pay = 0.0;
        if(employee instanceof ManagerEmployee) {
            pay = ((ManagerEmployee) employee).effectiveSalary();
        } else if(employee instanceof InternEmployee) {
            pay = ((InternEmployee) employee).effectiveSalary();
        } else if(employee != null) {
            pay = employee.getSalary();
        }

        // null check for parking slot
        String slotStr = (slot != null) ? slot.getSlotNo() : "no parking assigned";

        return name + " | Pay: Rs " + pay + " | Slot: " + slotStr;
    }
}
