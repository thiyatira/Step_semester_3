package oop.assigment_problems;

// Question F4: Designing instance vs static boundary
// Fixed version with correct separation
public class LibraryMember {
    // static fields belong to library overall
    private static String libraryName = "City Central Library";
    private static int memberCount = 0;

    // instance fields belong to individual member
    private String name;
    private String memberId;
    private int booksIssued;

    public LibraryMember(String name, int booksIssued) {
        memberCount++;
        this.name = name;
        this.booksIssued = booksIssued;
        this.memberId = "LM-" + (1000 + memberCount);
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }

    public static String getLibraryName() {
        return libraryName;
    }
}
