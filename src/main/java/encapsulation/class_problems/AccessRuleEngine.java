package encapsulation.class_problems;

/**
 * Week 5 Practice - Problems 1 & 2: Access Rule Engine
 * Simulates Java static analysis access rules across various package and class inheritance contexts.
 */
public class AccessRuleEngine {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        String mod = fieldModifier.trim().toLowerCase();
        String ctx = accessorContext.trim().toUpperCase();

        switch (ctx) {
            case "SAME_CLASS":
                // Every modifier is visible within the same class
                return "ALLOWED";

            case "SAME_PACKAGE":
                // default, protected, public are visible within same package
                if (mod.equals("default") || mod.equals("protected") || mod.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "DIFFERENT_PACKAGE":
                // Only public is accessible from a general different package
                return mod.equals("public") ? "ALLOWED" : "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                // In a subclass in a different package, protected is accessible through the subclass's own type
                if (mod.equals("protected") || mod.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
                // Protected member accessed via a reference to the parent type in a different package is NOT allowed
                return mod.equals("public") ? "ALLOWED" : "DENIED";

            default:
                return "DENIED";
        }
    }

    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.trim().isEmpty()) {
            return "";
        }

        String[] parts = accessorContext.trim().split("_");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String word = parts[i];
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
                if (i < parts.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static String summarizeBatch(String[][] attempts) {
        if (attempts == null) {
            return "Allowed: 0 | Denied: 0";
        }

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {
            if (attempt != null && attempt.length >= 2) {
                String result = classifyAccess(attempt[0], attempt[1]);
                if ("ALLOWED".equals(result)) {
                    allowed++;
                } else {
                    denied++;
                }
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}
