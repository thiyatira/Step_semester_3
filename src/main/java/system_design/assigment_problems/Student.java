package system_design.assigment_problems;

public class Student {
    private String name;
    private String id;
    private int currentCredits;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.currentCredits = 0;
    }

    public Student(String name, String id, int currentCredits) {
        this.name = name;
        this.id = id;
        this.currentCredits = currentCredits;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCurrentCredits() {
        return currentCredits;
    }

    public void addCredits(int credits) {
        this.currentCredits += credits;
    }

    public void deductCredits(int credits) {
        this.currentCredits -= credits;
    }

    public int getMaxCredits() {
        return 24;
    }

    public String getStudentType() {
        return "Regular";
    }
}
