package string.class_problems;

/**
 * Week 2 Practice - Problem 5: Bank Transaction Reference Generator & Validator
 * Normalizes, validates (without regex), and formats 14-char transaction references.
 */
public class BankTransactionRefValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String raw) {
        String normalized = normalizeReference(raw);

        if (normalized.length() != 14) {
            return "Invalid: length must be exactly 14 characters (found " + normalized.length() + ")";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: body characters after bank code must be digits";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String day = normalized.substring(3, 5);
        String month = normalized.substring(5, 7);
        String year = normalized.substring(7, 9);
        String seq = normalized.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testRefs = {
            "  hdf03022600042  ",
            "12F03022600042",
            "icici12345678",
            "sbi0101261234A",
            "sbi01012612345"
        };

        for (String ref : testRefs) {
            System.out.printf("Raw: \"%-18s\" -> %s%n", ref, validateAndFormat(ref));
        }
    }
}
