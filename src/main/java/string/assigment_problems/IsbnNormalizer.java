package string.assigment_problems;

// Question 4: ISBN normalizer and validator
public class IsbnNormalizer {

    // trim and capitalize first 3 letters
    public static String normalizeCode(String raw) {
        if(raw == null) return "";
        String s = raw.trim();
        if(s.length() < 3) {
            return s.toUpperCase();
        }
        return s.substring(0, 3).toUpperCase() + s.substring(3);
    }

    // validates 13 chars: 3 letters + 10 digits (no regex allowed)
    public static String validateAndFormat(String code) {
        if(code == null || code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        // check first 3 are letters
        for(int i = 0; i < 3; i++) {
            if(!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // check remaining 10 are digits
        for(int i = 3; i < 13; i++) {
            if(!Character.isDigit(code.charAt(i))) {
                return "Invalid: catalog body must be 10 digits";
            }
        }

        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pub).append("] ")
          .append("YEAR: ").append(year).append(" | ")
          .append("CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = "  pen2026004251  ";
        String n1 = normalizeCode(test1);
        System.out.println("Test Case 1 (\"" + test1 + "\"):");
        System.out.println(validateAndFormat(n1));

        String test2 = "12N2026004251";
        String n2 = normalizeCode(test2);
        System.out.println("\nTest Case 2 (\"" + test2 + "\"):");
        System.out.println(validateAndFormat(n2));
    }
}
