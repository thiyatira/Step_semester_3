package week12.class_problems;

// Hides pin fields and overrides its description.
public class HostelPin extends CampusPin {
    public static String banner = "Hostel";
    public String name = "Hostel Pin";

    @Override
    public String getDetails() {
        return "Details: " + name;
    }
}
