package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private ScoringTrack track;
    private List<Student> members;
    private String projectName;
    private Double finalScore;

    public Team(String teamName, ScoringTrack track) {
        this.teamName = teamName;
        this.track = track;
        this.members = new ArrayList<>();
    }

    public void addMember(Student student) {
        members.add(student);
    }

    public String getTeamName() {
        return teamName;
    }

    public ScoringTrack getTrack() {
        return track;
    }

    public List<Student> getMembers() {
        return members;
    }

    public int getMemberCount() {
        return members.size();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }
}
