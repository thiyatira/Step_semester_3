package system_design.assigment_problems;

public class OpenTrack implements ScoringTrack {
    @Override
    public double calculateScore(double idea, double execution, double presentation) {
        return (idea + execution + presentation) / 3.0;
    }

    @Override
    public String getTrackName() {
        return "Open";
    }
}
