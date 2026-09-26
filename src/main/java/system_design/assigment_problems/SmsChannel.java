package system_design.assigment_problems;

public class SmsChannel implements NotificationChannel {
    @Override
    public void notifyUpdate(String parcelId, ParcelStatus status) {
        System.out.printf("[SMS] %s is now %s.%n", parcelId, status);
    }
}
