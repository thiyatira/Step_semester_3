package system_design.assigment_problems;

public class A2_SwiftShipDemo {
    public static void main(String[] args) {
        Parcel p101 = new Parcel("P101", 2.0, new ExpressShipping());
        p101.addChannel(new SmsChannel());
        p101.addChannel(new EmailChannel());

        p101.confirmBooking();

        p101.advanceStatus(ParcelStatus.PICKED_UP);
        p101.cancel();

        p101.advanceStatus(ParcelStatus.IN_TRANSIT);
        p101.advanceStatus(ParcelStatus.DELIVERED);

        p101.advanceStatus(ParcelStatus.OUT_FOR_DELIVERY);
        p101.advanceStatus(ParcelStatus.DELIVERED);

        Parcel p102 = new Parcel("P102", 5.0, new FragileShipping());
        p102.addChannel(new SmsChannel());
        p102.confirmBooking();
        p102.cancel();
    }
}
