package system_design.assigment_problems;

public class InnovationTrack implements ScoringTrack {
    @Override
    public double calculateScore(double idea, double execution, double presentation) {
        return (idea * 0.5) + (execution * 0.3) + (presentation * 0.2);
    }

    @Override
    public String getTrackName() {
        return "Innovation";
    }
}
