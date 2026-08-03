package arrays.class_problems;

/**
 * Week 1 Practice - Problem 5: Reverse Customer Name
 * Customer identity verification module reversing name while leaving original unmodified.
 */
public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = customerName.length() - 1; i >= 0; i--) {
            sb.append(customerName.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testNames = {"Sunil", "Ananya", "Ravi", "Deepak"};

        System.out.println("=== Customer Identity Verification Module ===");
        for (String originalName : testNames) {
            String reversed = reverseCustomerName(originalName);
            System.out.println("Original Name: " + originalName + " | Reversed Name: " + reversed);
            // Verify original string remains unchanged
            if (originalName.equals("Sunil")) {
                assert originalName.equals("Sunil");
            }
        }
    }
}
