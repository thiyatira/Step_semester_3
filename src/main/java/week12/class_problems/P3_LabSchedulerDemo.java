package week12.class_problems;

// Demonstrates round-robin scheduling and completion order.
public class P3_LabSchedulerDemo {
    public static void main(String[] args) {
        LabScheduler scheduler = new LabScheduler(3);
        scheduler.addJob("P1", 5);
        scheduler.addJob("P2", 3);
        scheduler.addJob("P3", 7);
        scheduler.run();
    }
}
