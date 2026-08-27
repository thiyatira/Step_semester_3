package oop.assigment_problems;

// Broken version for demonstration where everything is static
class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    // constructor overwrites static variables every time!
    public BrokenLibraryMember(String n, String id, int books) {
        name = n;
        memberId = id;
        booksIssued = books;
    }
}

public class F4_LibraryMembershipSystem {

    // Question: Why marking fields static was wrong:
    // 1. name: each student has their own name, making it static overwrites previous member's name.
    // 2. memberId: each member must have a unique ID, static makes all members share the same ID.
    // 3. booksIssued: tracks individual books borrowed, static mixes up borrowing counts across everyone.
    // Only libraryName and memberCount should be static because they are common to whole library.

    public static void main(String[] args) {
        System.out.println("=== Broken Version Demonstration ===");
        BrokenLibraryMember m1 = new BrokenLibraryMember("Aditi", "LM-1001", 2);
        BrokenLibraryMember m2 = new BrokenLibraryMember("Rohan", "LM-1002", 1);

        System.out.println(BrokenLibraryMember.name);
        System.out.println(BrokenLibraryMember.name);
        System.out.println("(Aditi's data was overwritten -- both members now show \"Rohan\")\n");

        System.out.println("=== Fixed Version Demonstration ===");
        LibraryMember fixed1 = new LibraryMember("Aditi", 2);
        LibraryMember fixed2 = new LibraryMember("Rohan", 1);

        fixed1.printMemberCard();
        fixed2.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}
