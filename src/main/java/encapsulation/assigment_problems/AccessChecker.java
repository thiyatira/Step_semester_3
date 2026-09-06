package encapsulation.assigment_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Week 5 Assignment - Problems 1 & 2: Membership Field Reach Checker
 * Groups static visibility analysis per access modifier.
 */
public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        String mod = fieldModifier.trim().toLowerCase();
        String ctx = accessorContext.trim().toUpperCase();

        switch (ctx) {
            case "SAME_CLASS":
                return "ALLOWED";

            case "SAME_PACKAGE":
                if (mod.equals("default") || mod.equals("protected") || mod.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "DIFFERENT_PACKAGE":
                return mod.equals("public") ? "ALLOWED" : "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE":
                if (mod.equals("protected") || mod.equals("public")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE":
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

    public static String summarizeByModifier(String[][] attempts) {
        // Track allowed/denied counts grouped per modifier
        String[] modifiers = {"private", "default", "protected", "public"};
        Map<String, int[]> counts = new LinkedHashMap<>();
        for (String m : modifiers) {
            counts.put(m, new int[]{0, 0}); // [0]=allowed, [1]=denied
        }

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0].trim().toLowerCase();
                    String ctx = attempt[1];
                    String decision = classifyAccess(mod, ctx);

                    if (counts.containsKey(mod)) {
                        if ("ALLOWED".equals(decision)) {
                            counts.get(mod)[0]++;
                        } else {
                            counts.get(mod)[1]++;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            String m = modifiers[i];
            int[] c = counts.get(m);
            sb.append(m).append(": ").append(c[0]).append(" allowed / ").append(c[1]).append(" denied");
            if (i < modifiers.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}
