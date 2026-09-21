package abstraction_interface.class_problems;

// Abstract base class representing a library collection item with unique ID generation.
public abstract class LibraryItem {
    private static int itemCounter = 0;
    private final String itemId;

    public LibraryItem() {
        itemCounter++;
        this.itemId = "ITEM-" + (1000 + itemCounter);
    }

    public abstract int getLoanPeriodDays();

    public String getItemId() {
        return itemId;
    }

    // Static polymorphic processing across LibraryItem collection
    public static void processCheckouts(LibraryItem[] items) {
        if (items == null) return;
        for (LibraryItem item : items) {
            if (item != null) {
                System.out.println("Item " + item.getItemId() + " - Loan Period: " + item.getLoanPeriodDays() + " days");
            }
        }
    }

    // Safely checks any general Object for Reservable capability
    public static String reserveIfSupported(Object o) {
        if (o instanceof Reservable) {
            Reservable r = (Reservable) o;
            return r.reserve();
        }
        return "Reservation not supported";
    }
}
