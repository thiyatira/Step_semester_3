package system_design.class_problems;

import java.time.LocalDate;

public class Reservation {
    private String reservationId;
    private String customerName;
    private String roomName;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;
    private boolean active;

    public Reservation(String reservationId, String customerName, String roomName, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomName = roomName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.active = true;
    }

    public boolean overlaps(LocalDate in, LocalDate out) {
        if (!active) {
            return false;
        }
        return !(out.isEqual(checkIn) || out.isBefore(checkIn) || in.isEqual(checkOut) || in.isAfter(checkOut));
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        this.active = false;
    }
}
