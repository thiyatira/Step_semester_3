package oop.assigment_problems;

// testing F1 library fine system
public class F1_LibraryFineSystem {
    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Pooja", 0),
            new BookIssue("DSA Handbook", "Vikas", 21),
            new BookIssue("Design Patterns", "Neha", 9)
        };

        for(BookIssue b : issues) {
            String status = b.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(b.getTitle() + " - " + b.getDaysOverdue() + " days - " + status);
        }

        double total = BookIssue.totalFineCollected(issues);
        System.out.println("Total fine collected: Rs " + total);
    }
}
