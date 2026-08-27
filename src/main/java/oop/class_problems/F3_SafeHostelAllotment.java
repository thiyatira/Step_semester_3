package oop.class_problems;

/**
 * Week 3 Practice - Problem F3: Safe Hostel Allotment
 * Demonstrates null safety and pass-by-value of object references.
 */
public class F3_SafeHostelAllotment {

    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        if (rooms == null) return null;
        for (HostelRoom room : rooms) {
            if (room != null && room.hasAvailableBed()) {
                return room;
            }
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom available = findAvailableRoom(rooms);

        /*
         * REFERENCE PASSING EXPLANATION:
         * In Java, object references are passed by value. The method receives a copy
         * of the reference pointing to the same underlying HostelRoom object in memory.
         * Therefore, mutating state (such as room.allot()) directly changes the shared object.
         * The rooms array itself is never duplicated or copied.
         */
        if (available != null) {
            available.allot(studentName);
            System.out.println("safeAllot(rooms, \"" + studentName + "\") -> " + studentName + " allotted to room " + available.getRoomNo());
        } else {
            System.out.println("safeAllot(rooms, \"" + studentName + "\") -> No rooms available for " + studentName);
        }
    }

    public static void main(String[] args) {
        // Case 1: C-214 (2/3), C-507 (2/2) -> Available room exists
        HostelRoom[] roomsCase1 = {
            new HostelRoom("C-214", 3, 2),
            new HostelRoom("C-507", 2, 2)
        };
        safeAllot(roomsCase1, "Divya");

        // Case 2: C-214 (3/3), C-507 (2/2) -> Every room is full
        HostelRoom[] roomsCase2 = {
            new HostelRoom("C-214", 3, 3),
            new HostelRoom("C-507", 2, 2)
        };
        safeAllot(roomsCase2, "Divya");
    }
}
