package data_structures.class_problems;

// Demo: Library Platform — sorted array, binary search, capability dispatch.
public class P5_LibraryPlatformDemo {
    public static void main(String[] args) {
        LibraryPlatform lib = new LibraryPlatform();
        lib.add(new Book("B1"));
        lib.add(new Book("B1"));
        lib.add(new EBook("E1"));
        lib.reserve("B1", "M1");
        lib.download("B1");
        lib.download("E1");
        lib.find("E1");
    }
}
