package oop.class_problems;

// class problem 2: student grade calculation
class StudentGrade {
    private String studentName;
    private int[] marks;

    public StudentGrade(String studentName, int[] marks) {
        this.studentName = studentName;
        this.marks = marks;
    }

    public double calculateAverage() {
        if(marks == null || marks.length == 0) return 0.0;
        int sum = 0;
        for(int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public char determineGrade() {
        double avg = calculateAverage();
        if(avg >= 90) return 'A';
        if(avg >= 75) return 'B';
        if(avg >= 60) return 'C';
        if(avg >= 50) return 'D';
        return 'F';
    }

    public void printReportCard() {
        System.out.printf("Student: %s | Average: %.2f | Grade: %c%n",
                studentName, calculateAverage(), determineGrade());
    }
}

public class StudentGradeDemo {
    public static void main(String[] args) {
        int[] m1 = {85, 92, 78, 90};
        int[] m2 = {65, 70, 58, 62};

        StudentGrade s1 = new StudentGrade("Aman Verma", m1);
        StudentGrade s2 = new StudentGrade("Sneha Rao", m2);

        s1.printReportCard();
        s2.printReportCard();
    }
}
