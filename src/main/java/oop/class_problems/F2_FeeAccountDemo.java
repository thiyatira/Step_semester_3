package oop.class_problems;

/**
 * Week 3 Practice - Problem F2: Extending FeeAccount Demo
 * Demonstrates inheritance hierarchy and instanceof type dispatch.
 */
public class F2_FeeAccountDemo {

    public static void main(String[] args) {
        FeeAccount plain = new FeeAccount("RA2211003010101", 150000.0, 150000.0);
        HostelFeeAccount hostel = new HostelFeeAccount("RA2211003010102", 200000.0, 60000.0);
        ScholarshipFeeAccount scholarship = new ScholarshipFeeAccount("RA2211003010103", 180000.0, 0.0, 20.0);

        FeeAccount[] accounts = {plain, hostel, scholarship};

        for (FeeAccount acc : accounts) {
            if (acc instanceof ScholarshipFeeAccount) {
                ScholarshipFeeAccount sAcc = (ScholarshipFeeAccount) acc;
                System.out.println("Scholarship account effective due: Rs " + sAcc.effectiveDue());
            } else if (acc instanceof HostelFeeAccount) {
                HostelFeeAccount hAcc = (HostelFeeAccount) acc;
                System.out.println("Hostel account due: Rs " + hAcc.getDue());
            } else {
                System.out.println("Plain account due: Rs " + acc.getDue());
            }
        }
    }
}
