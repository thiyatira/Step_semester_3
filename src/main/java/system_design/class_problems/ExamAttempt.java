package system_design.class_problems;

import java.util.HashMap;
import java.util.Map;

public class ExamAttempt {
    private String studentId;
    private String examTitle;
    private Map<String, Question> questions;
    private Map<String, String> answers;
    private boolean isSubmitted;

    public ExamAttempt(String studentId, String examTitle) {
        this.studentId = studentId;
        this.examTitle = examTitle;
        this.questions = new HashMap<>();
        this.answers = new HashMap<>();
        this.isSubmitted = false;
    }

    public void addQuestion(Question question) {
        questions.put(question.getQuestionId(), question);
    }

    public void answerQuestion(String questionId, String answer) {
        if (isSubmitted) {
            System.out.println("Cannot change answers: Attempt is already submitted.");
            return;
        }
        answers.put(questionId, answer);
    }

    public void submit() {
        if (isSubmitted) {
            System.out.println("Exam is already submitted.");
            return;
        }
        this.isSubmitted = true;
        int totalPoints = 0;
        int scoredPoints = 0;
        for (Question q : questions.values()) {
            totalPoints += q.getPoints();
            String studentAns = answers.get(q.getQuestionId());
            if (q.evaluate(studentAns)) {
                scoredPoints += q.getPoints();
            }
        }
        double percentage = totalPoints > 0 ? (scoredPoints * 100.0 / totalPoints) : 0.0;
        System.out.printf("Exam '%s' submitted. Score: %d/%d (%.1f%%)%n", examTitle, scoredPoints, totalPoints, percentage);
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public String getExamTitle() {
        return examTitle;
    }
}
