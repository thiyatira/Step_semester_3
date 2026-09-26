package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Parcel {
    private String parcelId;
    private double weightKg;
    private ShippingType shippingType;
    private ParcelStatus status;
    private List<NotificationChannel> channels;

    public Parcel(String parcelId, double weightKg, ShippingType shippingType) {
        this.parcelId = parcelId;
        this.weightKg = weightKg;
        this.shippingType = shippingType;
        this.status = ParcelStatus.BOOKED;
        this.channels = new ArrayList<>();
    }

    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void confirmBooking() {
        double charge = shippingType.calculateCharge(weightKg);
        System.out.printf("Parcel %s booked (%s, %.0f kg). Charge: \u20B9%.2f.%n", parcelId, shippingType.getName(), weightKg, charge);
        notifyAllChannels();
    }

    public void advanceStatus(ParcelStatus nextStatus) {
        if (!isValidTransition(this.status, nextStatus)) {
            System.out.printf("Invalid transition: %s \u2192 %s is not allowed.%n", status, nextStatus);
            return;
        }
        this.status = nextStatus;
        notifyAllChannels();
    }

    public boolean cancel() {
        if (status != ParcelStatus.BOOKED) {
            System.out.printf("Cancellation failed: %s can be cancelled only while BOOKED.%n", parcelId);
            return false;
        }
        this.status = ParcelStatus.CANCELLED;
        System.out.printf("Parcel %s cancelled successfully.%n", parcelId);
        notifyAllChannels();
        return true;
    }

    private boolean isValidTransition(ParcelStatus current, ParcelStatus next) {
        if (current == ParcelStatus.BOOKED && next == ParcelStatus.PICKED_UP) return true;
        if (current == ParcelStatus.PICKED_UP && next == ParcelStatus.IN_TRANSIT) return true;
        if (current == ParcelStatus.IN_TRANSIT && next == ParcelStatus.OUT_FOR_DELIVERY) return true;
        if (current == ParcelStatus.OUT_FOR_DELIVERY && next == ParcelStatus.DELIVERED) return true;
        return false;
    }

    private void notifyAllChannels() {
        for (NotificationChannel channel : channels) {
            channel.notifyUpdate(parcelId, status);
        }
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public String getParcelId() {
        return parcelId;
    }
}
