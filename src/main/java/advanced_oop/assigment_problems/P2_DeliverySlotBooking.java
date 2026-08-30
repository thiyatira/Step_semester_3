package advanced_oop.assigment_problems;

// testing delivery slot booking
public class P2_DeliverySlotBooking {
    public static void main(String[] args) {
        DeliverySlot s1 = new DeliverySlot("ORD101", "13:00-14:00");
        DeliverySlot s2 = new DeliverySlot("ORD102"); // defaults to ASAP

        System.out.println("Slot 1 (" + s1.getOrderId() + ", " + s1.getTimeSlot() + ") isPeakHour: " + s1.isPeakHour());
        System.out.println("Slot 2 (" + s2.getOrderId() + ", " + s2.getTimeSlot() + ") isPeakHour: " + s2.isPeakHour());

        DeliverySlot s3 = new DeliverySlot("ORD103", "19:00-20:00");
        DeliverySlot s4 = new DeliverySlot("ORD104", "15:00-16:00");

        System.out.println("Slot 3 (" + s3.getOrderId() + ", " + s3.getTimeSlot() + ") isPeakHour: " + s3.isPeakHour());
        System.out.println("Slot 4 (" + s4.getOrderId() + ", " + s4.getTimeSlot() + ") isPeakHour: " + s4.isPeakHour());
    }
}
