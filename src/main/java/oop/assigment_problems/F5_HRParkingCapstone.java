package oop.assigment_problems;

// testing capstone HR and parking allocation
public class F5_HRParkingCapstone {
    public static void main(String[] args) {
        ManagerEmployee m = new ManagerEmployee("M101", "Divya", 70000, 8000);
        Employee e = new Employee("E102", "Karan", 40000);
        InternEmployee i = new InternEmployee("I103", "Meera", 12000, 10000);

        ParkingSlot slot1 = new ParkingSlot("A1", 1, 0);
        ParkingSlot slot2 = new ParkingSlot("A2", 1, 0);

        slot1.allot("DL01");
        slot2.allot("DL02");

        // third employee has null slot (no parking assigned)
        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "M101", m, slot1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E102", e, slot2);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "I103", i, null);

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
