package inheritance_polymorphism.class_problems;

// WorkshopTicket specializes EventTicket with track specialization and doubled late fees.
public class WorkshopTicket extends EventTicket {
    private String track;

    public WorkshopTicket(String attendeeId, double basePrice, String track) {
        super(attendeeId, basePrice);
        this.track = track;
    }

    public WorkshopTicket(double basePrice, String track) {
        super(basePrice);
        this.track = track;
    }

    public WorkshopTicket(double basePrice) {
        super(basePrice);
        this.track = "General";
    }

    public String getTrack() {
        return track;
    }

    @Override
    protected void applyLateFee(double amount) {
        super.applyLateFee(amount * 2);
    }

    @Override
    public String printTicket() {
        if (attendeeId != null && attendeeId.startsWith("STU")) {
            return "Workshop Ticket | Track: " + track + " | Balance Due: " + getBalanceDue();
        }
        return "Workshop | Track: " + track + " | Balance: " + getBalanceDue();
    }
}
