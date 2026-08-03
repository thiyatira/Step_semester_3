package arrays.assigment_problems;

// Question 1: Exam hall seat duplication checker
// Note: mentor said no collections allowed here, only basic arrays and nested loops
public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if(seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats provided.");
            return;
        }

        boolean found = false;

        for(int i = 0; i < seatNumbers.length; i++) {
            // check if this seat was already checked before so we dont print it again
            boolean alreadySeen = false;
            for(int k = 0; k < i; k++) {
                if(seatNumbers[k] == seatNumbers[i]) {
                    alreadySeen = true;
                    break;
                }
            }
            if(alreadySeen) continue;

            // compare with remaining seats
            for(int j = i + 1; j < seatNumbers.length; j++) {
                if(seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }

        if(!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] batch1 = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1 ({101, 102, 103, 102, 105}):");
        checkDuplicateSeats(batch1);

        int[] batch2 = {101, 102, 103, 104, 105};
        System.out.println("\nTest Case 2 ({101, 102, 103, 104, 105}):");
        checkDuplicateSeats(batch2);
    }
}
