package advanced_oop.class_problems;

/**
 * Week 4 Practice - Problem 1: Bus Ticket Booking Validator
 * Validates passenger name and destination at construction time and supports batch processing.
 */
public class BusTicket {
    private String passengerName;
    private String destination;
    private boolean checkedIn;

    // Parameterized constructor with validation; no default/no-arg constructor provided
    public BusTicket(String passengerName, String destination) {
        if (!isValidString(passengerName)) {
            throw new IllegalArgumentException("Invalid passenger name: must be non-blank letters only.");
        }
        if (!isValidString(destination)) {
            throw new IllegalArgumentException("Invalid destination: must be non-blank letters only.");
        }
        this.passengerName = passengerName.trim();
        this.destination = destination.trim();
        this.checkedIn = false;
    }

    private static boolean isValidString(String str) {
        if (str == null) return false;
        String trimmed = str.trim();
        if (trimmed.isEmpty()) return false;
        for (int i = 0; i < trimmed.length(); i++) {
            char ch = trimmed.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false; // Rejects numbers, special chars like "Ravi123"
            }
        }
        return true;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDestination() {
        return destination;
    }

    public void markCheckedIn() {
        if (checkedIn) {
            System.out.println("Alert: Ticket for " + passengerName + " to " + destination + " is already checked in!");
        } else {
            this.checkedIn = true;
            System.out.println("Check-in successful for " + passengerName + " to " + destination + ".");
        }
    }

    public static void processBatch(String[][] rawBookings) {
        if (rawBookings == null) return;

        int validCount = 0;
        int rejectedCount = 0;
        int duplicatesSkipped = 0;

        // Up to 1000 entries
        String[] acceptedPairs = new String[rawBookings.length];

        for (String[] booking : rawBookings) {
            if (booking == null || booking.length < 2) {
                rejectedCount++;
                continue;
            }

            String name = booking[0];
            String dest = booking[1];

            try {
                BusTicket ticket = new BusTicket(name, dest);
                String pair = ticket.getPassengerName().toLowerCase() + "->" + ticket.getDestination().toLowerCase();

                // Check for duplicate already accepted pair
                boolean isDuplicate = false;
                for (int i = 0; i < validCount; i++) {
                    if (acceptedPairs[i].equals(pair)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    duplicatesSkipped++;
                } else {
                    acceptedPairs[validCount] = pair;
                    validCount++;
                }
            } catch (IllegalArgumentException e) {
                rejectedCount++;
            }
        }

        System.out.printf("Valid: %d | Rejected: %d | Duplicates skipped: %d%n",
                validCount, rejectedCount, duplicatesSkipped);
    }
}
