package system_design.assigment_problems;

public interface ScoringTrack {
    double calculateScore(double idea, double execution, double presentation);
    String getTrackName();
}
