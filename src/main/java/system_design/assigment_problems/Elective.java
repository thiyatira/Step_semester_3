package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Elective {
    private String courseName;
    private int credits;
    private int capacity;
    private List<Student> enrolledStudents;
    private List<Student> waitlist;

    public Elective(String courseName, int credits, int capacity) {
        this.courseName = courseName;
        this.credits = credits;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.waitlist = new ArrayList<>();
    }

    public String enrollStudent(Student student) {
        if (student.getCurrentCredits() + credits > student.getMaxCredits()) {
            return "Enrollment failed: " + student.getName() + " would exceed the " + student.getStudentType() + " credit limit (" + (student.getCurrentCredits() + credits) + "/" + student.getMaxCredits() + ").";
        }
        if (enrolledStudents.size() < capacity) {
            student.addCredits(credits);
            enrolledStudents.add(student);
            return student.getName() + " enrolled in " + courseName + " (credits: " + student.getCurrentCredits() + "/" + student.getMaxCredits() + ").";
        }
        waitlist.add(student);
        return courseName + " is full. " + student.getName() + " added to waitlist (position " + waitlist.size() + ").";
    }

    public String dropStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            return student.getName() + " is not enrolled in " + courseName + ".";
        }
        enrolledStudents.remove(student);
        student.deductCredits(credits);
        String msg = student.getName() + " dropped " + courseName + ".";
        for (int i = 0; i < waitlist.size(); i++) {
            Student next = waitlist.get(i);
            if (next.getCurrentCredits() + credits <= next.getMaxCredits()) {
                waitlist.remove(i);
                next.addCredits(credits);
                enrolledStudents.add(next);
                msg += " " + next.getName() + " promoted from waitlist and enrolled.";
                break;
            }
        }
        return msg;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Student> getWaitlist() {
        return waitlist;
    }
}
