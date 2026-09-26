package system_design.assigment_problems;

public interface NotificationChannel {
    void notifyUpdate(String parcelId, ParcelStatus status);
}
