package inheritance_polymorphism.class_problems;

// GroupTicket models a bulk ticket registration with a designated party size.
public class GroupTicket extends EventTicket {
    private int groupSize;

    public GroupTicket(double basePrice, int groupSize) {
        super(basePrice);
        if (groupSize <= 0) {
            throw new IllegalArgumentException("Group size must be positive.");
        }
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}
