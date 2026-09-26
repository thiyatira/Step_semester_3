package system_design.assigment_problems;

public class A1_CodeSprintDemo {
    public static void main(String[] args) {
        Hackathon sprint = new Hackathon("Code Sprint");

        Team byteBusters = new Team("ByteBusters", new InnovationTrack());
        byteBusters.addMember(new Student("Asha", "S1"));
        byteBusters.addMember(new Student("Ravi", "S2"));
        byteBusters.addMember(new Student("Neha", "S3"));
        sprint.registerTeam(byteBusters);

        Team soloCoder = new Team("SoloCoder", new OpenTrack());
        soloCoder.addMember(new Student("Kiran", "S4"));
        sprint.registerTeam(soloCoder);

        sprint.submitProject("ByteBusters", "SmartAttend");

        sprint.scoreProject("ByteBusters", 8, 7, 9);

        sprint.publishResults();

        sprint.scoreProject("ByteBusters", 10, 7, 9);
    }
}
