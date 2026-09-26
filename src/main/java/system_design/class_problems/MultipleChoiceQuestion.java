package system_design.class_problems;

public class MultipleChoiceQuestion implements Question {
    private String questionId;
    private String questionText;
    private String correctAnswer;
    private int points;

    public MultipleChoiceQuestion(String questionId, String questionText, String correctAnswer, int points) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    @Override
    public String getQuestionId() {
        return questionId;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public boolean evaluate(String studentAnswer) {
        if (studentAnswer == null) {
            return false;
        }
        return correctAnswer.trim().equalsIgnoreCase(studentAnswer.trim());
    }

    @Override
    public int getPoints() {
        return points;
    }
}
