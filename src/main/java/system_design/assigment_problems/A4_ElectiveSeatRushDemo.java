package system_design.assigment_problems;

public class A4_ElectiveSeatRushDemo {
    public static void main(String[] args) {
        Elective cloudCourse = new Elective("Cloud Computing", 4, 1);

        Student asha = new RegularStudent("Asha", "S01", 20);
        Student neha = new RegularStudent("Neha", "S02", 16);
        Student kiran = new RegularStudent("Kiran", "S03", 22);

        System.out.println(cloudCourse.enrollStudent(asha));
        System.out.println(cloudCourse.enrollStudent(neha));
        System.out.println(cloudCourse.enrollStudent(kiran));
        System.out.println(cloudCourse.dropStudent(asha));
    }
}
