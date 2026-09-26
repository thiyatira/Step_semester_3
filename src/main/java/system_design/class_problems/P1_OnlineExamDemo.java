package system_design.class_problems;

public class P1_OnlineExamDemo {
    public static void main(String[] args) {
        ExamAttempt attempt = new ExamAttempt("STU101", "Math Quiz");

        Question q1 = new MultipleChoiceQuestion("Q1", "What is 2 + 2?", "A", 1);
        Question q2 = new MultipleChoiceQuestion("Q2", "What is 5 * 3?", "B", 1);

        attempt.addQuestion(q1);
        attempt.addQuestion(q2);

        attempt.answerQuestion("Q1", "A");
        attempt.answerQuestion("Q2", "B");

        attempt.submit();

        attempt.answerQuestion("Q1", "C");
    }
}
