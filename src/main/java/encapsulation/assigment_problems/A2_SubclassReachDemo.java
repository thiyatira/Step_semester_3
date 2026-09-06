package encapsulation.assigment_problems;

/**
 * Week 5 Assignment - Problem 2 Demo
 */
public class A2_SubclassReachDemo {

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE\"): " +
                AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE\"): " +
                AccessChecker.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        System.out.println("describeContext(\"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE\"): \"" +
                AccessChecker.describeContext("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE") + "\"");
    }
}
