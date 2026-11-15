package week12.class_problems;

// Shows field hiding and dynamic method dispatch.
public class P4_CampusPinDemo {
    public static void main(String[] args) {
        CampusPin p = new HostelPin();
        System.out.println("banner: " + p.banner + " (decided by reference type)");
        System.out.println("name: " + p.name + " (decided by reference type)");
        System.out.println(p.getDetails() + " (decided by object type)");
    }
}
