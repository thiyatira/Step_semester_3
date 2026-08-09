package string.class_problems;

/**
 * Week 2 Practice - Problem 4: Masked Phone Number Formatter
 * Validates 10-digit number and constructs masked version XXXXXX-1234 using StringBuilder.
 */
public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX-");
        masked.append(phone.substring(6));

        return masked.toString();
    }

    public static void main(String[] args) {
        String[] phones = {"9876543210", "98765", "987654321012", "98765abc10"};

        for (String p : phones) {
            System.out.printf("Phone: %-14s -> %s%n", p, maskPhoneNumber(p));
        }
    }
}
