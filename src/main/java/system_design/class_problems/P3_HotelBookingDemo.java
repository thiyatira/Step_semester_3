package system_design.class_problems;

public class P3_HotelBookingDemo {
    public static void main(String[] args) {
        HotelBookingManager manager = new HotelBookingManager();

        Room room101 = new Room("R101", "Deluxe Room 101", "Deluxe", 200.0);
        Room room205 = new Room("R205", "Standard Room 205", "Standard", 150.0);

        String resId1 = manager.bookRoom("Customer", room101, "2024-12-01", "2024-12-05");
        manager.bookRoom("Customer", room205, "2024-12-03", "2024-12-07");

        manager.bookRoom("Customer", room101, "2024-12-03", "2024-12-07");

        manager.cancelReservation(resId1);
    }
}
