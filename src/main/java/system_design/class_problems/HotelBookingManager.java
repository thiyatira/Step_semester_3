package system_design.class_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class HotelBookingManager {
    private Map<String, Reservation> allReservations = new HashMap<>();
    private int counter = 100;

    public String bookRoom(String customerName, Room room, String checkInStr, String checkOutStr) {
        LocalDate checkIn = LocalDate.parse(checkInStr);
        LocalDate checkOut = LocalDate.parse(checkOutStr);

        if (!room.isAvailable(checkIn, checkOut)) {
            String msg = String.format("Booking failed: %s is not available for %s to %s.", room.getRoomName(), checkInStr, checkOutStr);
            System.out.println(msg);
            return msg;
        }

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double totalPrice = nights * room.getRatePerNight();
        String resId = "RES-" + (++counter);

        Reservation res = new Reservation(resId, customerName, room.getRoomName(), checkIn, checkOut, totalPrice);
        room.addReservation(res);
        allReservations.put(resId, res);

        String msg = String.format("%s booked from %s to %s. Total price: $%.2f", room.getRoomName(), checkInStr, checkOutStr, totalPrice);
        System.out.println(msg);
        return resId;
    }

    public void cancelReservation(String resId) {
        Reservation res = allReservations.get(resId);
        if (res == null || !res.isActive()) {
            System.out.println("Cancellation failed: Reservation not found or already cancelled.");
            return;
        }
        res.cancel();
        System.out.printf("Reservation for %s cancelled successfully.%n", res.getRoomName());
    }
}
