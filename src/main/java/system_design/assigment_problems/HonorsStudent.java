package system_design.assigment_problems;

public class HonorsStudent extends Student {
    public HonorsStudent(String name, String id, int currentCredits) {
        super(name, id, currentCredits);
    }

    @Override
    public int getMaxCredits() {
        return 28;
    }

    @Override
    public String getStudentType() {
        return "Honors";
    }
}
