package oop.class_problems;

/**
 * Week 3 Practice - Problem F3: HostelRoom Model
 * Manages room capacity, occupied count, and room bed allotment.
 */
public class HostelRoom {
    private String roomNo;
    private int beds;
    private int occupied;

    public HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public int getBeds() {
        return beds;
    }

    public int getOccupied() {
        return occupied;
    }

    public boolean allot(String name) {
        if (occupied < beds) {
            occupied++;
            return true;
        }
        return false;
    }

    public boolean hasAvailableBed() {
        return occupied < beds;
    }
}
