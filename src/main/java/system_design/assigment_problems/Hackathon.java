package system_design.assigment_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hackathon {
    private String name;
    private Map<String, Team> teams;
    private Set<String> registeredStudentIds;
    private boolean isPublished;

    public Hackathon(String name) {
        this.name = name;
        this.teams = new HashMap<>();
        this.registeredStudentIds = new HashSet<>();
        this.isPublished = false;
    }

    public boolean registerTeam(Team team) {
        if (team.getMemberCount() < 2 || team.getMemberCount() > 4) {
            System.out.println("Registration failed: A team must have 2 to 4 members.");
            return false;
        }

        for (Student s : team.getMembers()) {
            if (registeredStudentIds.contains(s.getId())) {
                System.out.println("Registration failed: Student already in another team.");
                return false;
            }
        }

        for (Student s : team.getMembers()) {
            registeredStudentIds.add(s.getId());
        }

        teams.put(team.getTeamName(), team);
        System.out.printf("Team %s registered (%d members, %s track).%n", team.getTeamName(), team.getMemberCount(), team.getTrack().getTrackName());
        return true;
    }

    public void submitProject(String teamName, String projectName) {
        Team team = teams.get(teamName);
        if (team == null) {
            System.out.println("Submission failed: Team not found.");
            return;
        }
        team.setProjectName(projectName);
        System.out.printf("Project '%s' submitted by %s.%n", projectName, teamName);
    }

    public void scoreProject(String teamName, double idea, double execution, double presentation) {
        if (isPublished) {
            System.out.println("Rescore rejected: Results have already been published.");
            return;
        }

        Team team = teams.get(teamName);
        if (team == null) {
            System.out.println("Scoring failed: Team not found.");
            return;
        }

        double finalScore = team.getTrack().calculateScore(idea, execution, presentation);
        team.setFinalScore(finalScore);
        System.out.printf("Score recorded for '%s'. Final score: %.2f.%n", team.getProjectName(), finalScore);
    }

    public void publishResults() {
        this.isPublished = true;
        System.out.println("Results published.");
    }
}
