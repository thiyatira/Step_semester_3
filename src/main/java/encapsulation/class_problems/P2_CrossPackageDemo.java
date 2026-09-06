package encapsulation.class_problems;

/**
 * Week 5 Practice - Problem 2: Cross-Package Inheritance Reach Demo
 */
public class P2_CrossPackageDemo {

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE\"): " +
                AccessRuleEngine.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));

        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE\"): " +
                AccessRuleEngine.classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        System.out.println("describeContext(\"SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE\"): \"" +
                AccessRuleEngine.describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE") + "\"");
    }
}
