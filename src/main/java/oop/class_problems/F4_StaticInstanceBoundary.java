package oop.class_problems;

/**
 * Week 3 Practice - Problem F4: Designing the Instance/Static Boundary
 * Reproduces static collision bug and provides corrected instance/static architecture.
 */
public class F4_StaticInstanceBoundary {

    // BROKEN DESIGN: All fields marked static causing data collision
    public static class BrokenSrmStudent {
        public static String name;
        public static String regNo;
        public static int attendance;
        /*
         * WHY STATIC IS WRONG HERE:
         * 1. name: static means only one name exists for the entire class. Every new student overwrites the previous name.
         * 2. regNo: static means all students share the identical registration number.
         * 3. attendance: static means updating one student's attendance changes everyone's attendance.
         */
    }

    // FIXED DESIGN: Correct separation of instance vs static scope
    public static class ValidSrmStudent {
        // Instance fields: unique per student
        private String name;
        private String regNo;
        private int attendance;

        // Static fields: shared across entire university
        private static String university = "SRM Institute of Science and Technology";
        private static int admissionCount = 10;

        public ValidSrmStudent(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            admissionCount++;
            this.regNo = "RA2311003010" + admissionCount;
        }

        public void printIdCard() {
            System.out.println(this.name + " | " + this.regNo);
        }

        public static void printTotalAdmissions() {
            System.out.println("Students admitted so far: " + (admissionCount - 10));
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Broken Version Output (Static Collision Bug) ---");
        BrokenSrmStudent.name = "Ravi";
        BrokenSrmStudent.regNo = "RA231100301001";
        BrokenSrmStudent.attendance = 82;

        BrokenSrmStudent.name = "Meera";
        BrokenSrmStudent.regNo = "RA231100301002";
        BrokenSrmStudent.attendance = 74;

        // Both student references now evaluate to Meera because the field is static!
        System.out.println(BrokenSrmStudent.name);
        System.out.println(BrokenSrmStudent.name);
        System.out.println("(Ravi's data was overwritten — both students now show \"Meera\")\n");

        System.out.println("--- Fixed Version Output ---");
        ValidSrmStudent s1 = new ValidSrmStudent("Ravi", 82);
        ValidSrmStudent s2 = new ValidSrmStudent("Meera", 74);

        s1.printIdCard();
        s2.printIdCard();
        ValidSrmStudent.printTotalAdmissions();
    }
}
