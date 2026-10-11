package data_structures.class_problems;

// Physical book resource that supports reservation but not download.
public class Book extends Resource implements Reservable {

    public Book(String id) { super(id); }

    @Override
    public void reserve(String memberId) {
        System.out.println(getId() + " reserved for " + memberId);
    }
}
