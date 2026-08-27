package oop.class_problems;

/**
 * Week 3 Practice - Problem F5: Capstone — Fee + Hostel Management Mini-System
 * Demonstrates composition, static tracking, and null-safe object references.
 */
public class F5_FeeHostelCapstone {

    public static class SrmStudentCapstone {
        private String name;
        private String regNo;
        private HostelFeeAccount feeAccount;
        private HostelRoom room;
        public static int totalStudents = 0;

        public SrmStudentCapstone(String name, String regNo, HostelFeeAccount feeAccount) {
            this.name = name;
            this.regNo = regNo;
            this.feeAccount = feeAccount;
            this.room = null; // unallotted initially
            totalStudents++;
        }

        public void assignRoom(HostelRoom room) {
            this.room = room;
        }

        public HostelFeeAccount getFeeAccount() {
            return feeAccount;
        }

        public String fullStatus() {
            String roomStatus = (room != null) ? room.getRoomNo() : "unallotted";
            double due = (feeAccount != null) ? feeAccount.getDue() : 0.0;
            return name + " | Due: Rs " + due + " | Room: " + roomStatus;
        }
    }

    public static void main(String[] args) {
        // Create 3 students with hostel fee accounts
        HostelFeeAccount f1 = new HostelFeeAccount("RA2211003010201", 200000.0, 60000.0);
        HostelFeeAccount f2 = new HostelFeeAccount("RA2211003010202", 200000.0, 20000.0);
        HostelFeeAccount f3 = new HostelFeeAccount("RA2211003010203", 200000.0, 0.0);

        SrmStudentCapstone s1 = new SrmStudentCapstone("Ravi", "RA2211003010201", f1);
        SrmStudentCapstone s2 = new SrmStudentCapstone("Anitha", "RA2211003010202", f2);
        SrmStudentCapstone s3 = new SrmStudentCapstone("Karthik", "RA2211003010203", f3);

        // Rooms setup
        HostelRoom r1 = new HostelRoom("C-214", 3, 2);
        HostelRoom r2 = new HostelRoom("C-507", 2, 1);

        // Allot rooms to only two students, third is left unallotted
        if (r1.allot("Ravi")) {
            s1.assignRoom(r1);
        }
        if (r2.allot("Anitha")) {
            s2.assignRoom(r2);
        }

        // Test payment handling
        s1.getFeeAccount().pay(-500.0); // rejected non-positive payment

        // Print full status
        System.out.println(s1.fullStatus());
        System.out.println(s2.fullStatus());
        System.out.println(s3.fullStatus());
        System.out.println("Total students: " + SrmStudentCapstone.totalStudents);
    }
}
