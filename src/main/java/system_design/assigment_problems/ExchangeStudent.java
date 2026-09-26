package system_design.assigment_problems;

public class ExchangeStudent extends Student {
    public ExchangeStudent(String name, String id, int currentCredits) {
        super(name, id, currentCredits);
    }

    @Override
    public int getMaxCredits() {
        return 20;
    }

    @Override
    public String getStudentType() {
        return "Exchange";
    }
}
