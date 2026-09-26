package system_design.class_problems;

public interface Question {
    String getQuestionId();
    String getQuestionText();
    boolean evaluate(String studentAnswer);
    int getPoints();
}
