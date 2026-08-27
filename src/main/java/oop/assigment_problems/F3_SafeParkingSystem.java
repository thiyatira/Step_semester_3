package oop.assigment_problems;

// testing null-safe parking allotment
public class F3_SafeParkingSystem {

    // find first slot with free capacity
    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        if(slots == null) return null;
        for(ParkingSlot slot : slots) {
            if(slot != null && slot.isAvailable()) {
                return slot;
            }
        }
        return null; // no slot found
    }

    // null-safe allotment method
    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot freeSlot = findAvailableSlot(slots);

        // check for null to prevent NullPointerException
        if(freeSlot != null) {
            freeSlot.allot(vehicleNo);
            System.out.println(vehicleNo + " allotted to slot " + freeSlot.getSlotNo());
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    // Question: why passing ParkingSlot array does not copy the slots?
    // Answer: In Java, arrays store object references. Passing array into method
    // only passes a copy of the reference to the array. The actual ParkingSlot
    // objects in memory are not copied, so any mutation affects the original slots.

    public static void main(String[] args) {
        // test 1: when slot A1 is free (capacity 4, occupied 3)
        ParkingSlot[] slots1 = {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(slots1, "TN09AB1234");

        // test 2: when all slots are full
        ParkingSlot[] slots2 = {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(slots2, "TN09AB1234");
    }
}
