package system_design.class_problems;

public class P4_EmployeeLeaveDemo {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", "Full-time");
        LeaveRequest req1 = new LeaveRequest(john, "2024-10-10", "2024-10-12");

        req1.approve();

        Employee jane = new Employee("Jane Smith", "Part-time");
        LeaveRequest req2 = new LeaveRequest(jane, "2024-11-01", "2024-11-05");

        req1.revertToPending();
    }
}
