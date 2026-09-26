package system_design.class_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomId;
    private String roomName;
    private String category;
    private double ratePerNight;
    private List<Reservation> reservations;

    public Room(String roomId, String roomName, String category, double ratePerNight) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.category = category;
        this.ratePerNight = ratePerNight;
        this.reservations = new ArrayList<>();
    }

    public boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
        for (Reservation res : reservations) {
            if (res.overlaps(checkIn, checkOut)) {
                return false;
            }
        }
        return true;
    }

    public void addReservation(Reservation res) {
        reservations.add(res);
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getCategory() {
        return category;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
