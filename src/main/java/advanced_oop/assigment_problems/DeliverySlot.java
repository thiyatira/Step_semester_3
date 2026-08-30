package advanced_oop.assigment_problems;

// Question 2: Delivery slot booking
public class DeliverySlot {
    private String orderId;
    private String timeSlot;

    // full constructor
    public DeliverySlot(String orderId, String timeSlot) {
        this.orderId = (orderId != null) ? orderId.trim() : "";
        this.timeSlot = (timeSlot != null && !timeSlot.trim().isEmpty()) ? timeSlot.trim() : "ASAP";
    }

    // chained constructor defaulting to ASAP via this(...)
    public DeliverySlot(String orderId) {
        this(orderId, "ASAP");
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    // checking 4 peak hour slots
    public boolean isPeakHour() {
        return "12:00-13:00".equals(timeSlot)
                || "13:00-14:00".equals(timeSlot)
                || "19:00-20:00".equals(timeSlot)
                || "20:00-21:00".equals(timeSlot);
    }
}
