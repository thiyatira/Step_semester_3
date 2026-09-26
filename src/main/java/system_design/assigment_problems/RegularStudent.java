package system_design.assigment_problems;

public class RegularStudent extends Student {
    public RegularStudent(String name, String id, int currentCredits) {
        super(name, id, currentCredits);
    }

    @Override
    public int getMaxCredits() {
        return 24;
    }

    @Override
    public String getStudentType() {
        return "Regular";
    }
}
