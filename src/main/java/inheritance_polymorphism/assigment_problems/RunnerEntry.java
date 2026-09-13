package inheritance_polymorphism.assigment_problems;

// RunnerEntry specializes RaceEntry with running category and doubled late fees.
public class RunnerEntry extends RaceEntry {
    private String category;

    public RunnerEntry(String bibNumber, double entryFee, String category) {
        super(bibNumber, entryFee);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    protected void applyLateFee(double amount) {
        super.applyLateFee(amount * 2);
    }

    @Override
    public String announce() {
        return "Runner Entry | Bib: " + bibNumber + " | Category: " + category + " | Balance: " + balanceDue;
    }
}
