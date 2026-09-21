package abstraction_interface.class_problems;

// Textbook extending LibraryItem and implementing both Renewable and Reservable.
public class Textbook extends LibraryItem implements Renewable, Reservable {
    private String title;

    public Textbook(String title) {
        super();
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title.trim();
    }

    @Override
    public int getLoanPeriodDays() {
        return 14;
    }

    @Override
    public String renew() {
        return title + " renewed";
    }

    @Override
    public String reserve() {
        return title + " reserved";
    }

    public String getTitle() {
        return title;
    }
}
