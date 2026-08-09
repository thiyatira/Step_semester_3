package string.assigment_problems;

// Question 1: ATM pin length validator
// only length() and if/else, no loops needed
public class PinValidator {

    public static void checkPinLength(String pin) {
        if(pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1 (\"482\"):");
        checkPinLength("482");

        System.out.println("\nTest Case 2 (\"4820\"):");
        checkPinLength("4820");
    }
}
