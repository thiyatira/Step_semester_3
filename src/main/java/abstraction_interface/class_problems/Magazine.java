package abstraction_interface.class_problems;

// Magazine extending LibraryItem and implementing Renewable only (not Reservable).
public class Magazine extends LibraryItem implements Renewable {
    private String title;

    public Magazine(String title) {
        super();
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title.trim();
    }

    @Override
    public int getLoanPeriodDays() {
        return 7;
    }

    @Override
    public String renew() {
        return title + " renewed";
    }

    public String getTitle() {
        return title;
    }
}
