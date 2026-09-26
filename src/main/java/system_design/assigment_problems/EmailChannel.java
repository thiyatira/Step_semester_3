package system_design.assigment_problems;

public class EmailChannel implements NotificationChannel {
    @Override
    public void notifyUpdate(String parcelId, ParcelStatus status) {
        System.out.printf("[Email] %s is now %s.%n", parcelId, status);
    }
}
