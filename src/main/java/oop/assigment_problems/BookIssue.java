package oop.assigment_problems;

// Homework Problem F1: Library Fine System
// converting old procedural code into proper OOP class
public class BookIssue {
    private String title;
    private String borrowerName;
    private int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public String getTitle() {
        return title;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    // fine is 5 Rs per day overdue
    public double fineAmount() {
        if(daysOverdue > 0) {
            return daysOverdue * 5.0;
        }
        return 0.0;
    }

    // flag if overdue is more than 14 days
    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    // Question: why totalFineCollected is static while fineAmount is not?
    // Answer: fineAmount is instance method because each book has its own daysOverdue.
    // But totalFineCollected takes an array of books and calculates the total fine
    // across all of them, so it belongs to the class as a whole and not any single book.
    public static double totalFineCollected(BookIssue[] issues) {
        if(issues == null) return 0.0;
        double total = 0.0;
        for(BookIssue b : issues) {
            if(b != null) {
                total += b.fineAmount();
            }
        }
        return total;
    }
}
