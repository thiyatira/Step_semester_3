package oop.assigment_problems;

// ParkingSlot class tracking capacity and occupied slots
public class ParkingSlot {
    private String slotNo;
    private int capacity;
    private int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedCount() {
        return occupiedCount;
    }

    public boolean isAvailable() {
        return occupiedCount < capacity;
    }

    public boolean allot(String vehicleNo) {
        if(isAvailable()) {
            occupiedCount++;
            return true;
        }
        return false;
    }
}
