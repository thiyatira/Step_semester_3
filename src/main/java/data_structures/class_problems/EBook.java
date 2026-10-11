package data_structures.class_problems;

// Digital ebook that supports both reservation and download.
public class EBook extends Resource implements Reservable, Downloadable {

    public EBook(String id) { super(id); }

    @Override
    public void reserve(String memberId) {
        System.out.println(getId() + " reserved for " + memberId);
    }

    @Override
    public void download() {
        System.out.println(getId() + " downloaded");
    }
}
