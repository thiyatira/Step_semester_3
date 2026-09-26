package system_design.class_problems;

public class LeaveRequest {
    private Employee employee;
    private String startDate;
    private String endDate;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, String startDate, String endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = LeaveStatus.PENDING;
        System.out.printf("Leave request submitted by %s for %s to %s. Status: %s.%n", employee.getName(), startDate, endDate, status);
    }

    public void approve() {
        if (status != LeaveStatus.PENDING) {
            System.out.println("Cannot change status: Already finalized.");
            return;
        }
        this.status = LeaveStatus.APPROVED;
        System.out.printf("Leave request for %s approved. Status: %s.%n", employee.getName(), status);
    }

    public void reject() {
        if (status != LeaveStatus.PENDING) {
            System.out.println("Cannot change status: Already finalized.");
            return;
        }
        this.status = LeaveStatus.REJECTED;
        System.out.printf("Leave request for %s rejected. Status: %s.%n", employee.getName(), status);
    }

    public void revertToPending() {
        if (status == LeaveStatus.APPROVED || status == LeaveStatus.REJECTED) {
            System.out.println("Cannot change status: Approved request cannot revert to Pending.");
            return;
        }
        this.status = LeaveStatus.PENDING;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public Employee getEmployee() {
        return employee;
    }
}
