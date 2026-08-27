package oop.class_problems;

/**
 * Week 3 Practice - Problem F1: From Procedural Mess to a Working Attendance System
 * Implements SrmStudent class with instance methods and static class-level average calculation.
 */
public class F1_AttendanceSystem {

    public static class SrmStudent {
        private String name;
        private String regNo;
        private int attendance;

        public SrmStudent(String name, String regNo, int attendance) {
            this.name = name;
            this.regNo = regNo;
            this.attendance = attendance;
        }

        public String getName() {
            return name;
        }

        public String getRegNo() {
            return regNo;
        }

        public int getAttendance() {
            return attendance;
        }

        public void addAttendanceUpdate(int newAttendance) {
            this.attendance = newAttendance;
        }

        public boolean isEligible() {
            return this.attendance >= 75;
        }

        /*
         * DESIGN JUSTIFICATION:
         * - isEligible() is an INSTANCE method because eligibility is an individual property
         *   that depends strictly on the attendance record of a specific student instance.
         * - classAverage() is a STATIC method because computing the average attendance
         *   is a class-level, aggregate operation over an entire collection/array of students.
         *   It belongs to the SrmStudent concept as a whole, rather than any single individual student.
         */
        public static double classAverage(SrmStudent[] students) {
            if (students == null || students.length == 0) {
                return 0.0;
            }
            int total = 0;
            for (SrmStudent s : students) {
                if (s != null) {
                    total += s.getAttendance();
                }
            }
            return (double) total / students.length;
        }
    }

    public static void main(String[] args) {
        SrmStudent[] students = {
            new SrmStudent("Ravi", "RA2211003010001", 82),
            new SrmStudent("Anitha", "RA2211003010002", 68),
            new SrmStudent("Karthik", "RA2211003010003", 91),
            new SrmStudent("Meera", "RA2211003010004", 74),
            new SrmStudent("Suresh", "RA2211003010005", 60)
        };

        for (SrmStudent s : students) {
            String status = s.isEligible() ? "Eligible" : "Detained";
            System.out.printf("%s - %d%% - %s%n", s.getName(), s.getAttendance(), status);
        }

        double avg = SrmStudent.classAverage(students);
        System.out.printf("Class average: %.1f%%%n", avg);
    }
}
