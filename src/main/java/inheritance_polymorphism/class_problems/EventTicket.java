package inheritance_polymorphism.class_problems;

import java.util.Arrays;

// Base class for CineHub tech fest tickets handling identification, balance, and fees.
public class EventTicket {
    private static int ticketsIssued = 0;

    public final String ticketId;
    protected String attendeeId;
    protected double basePrice;
    protected double balanceDue;
    private double[] lateFeeHistory;
    private int lateFeeCount;

    public EventTicket(String attendeeId, double basePrice) {
        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("Attendee ID must be at least 4 characters long.");
        }
        if (basePrice < 0) {
            throw new IllegalArgumentException("Base price cannot be negative.");
        }

        ticketsIssued++;
        this.ticketId = "TCK-" + (1000 + ticketsIssued);
        this.attendeeId = attendeeId.trim();
        this.basePrice = basePrice;
        this.balanceDue = basePrice;
        this.lateFeeHistory = new double[10];
        this.lateFeeCount = 0;
    }

    public EventTicket(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException("Base price cannot be negative.");
        }

        ticketsIssued++;
        this.ticketId = "TCK-" + (1000 + ticketsIssued);
        this.attendeeId = null;
        this.basePrice = basePrice;
        this.balanceDue = basePrice;
        this.lateFeeHistory = new double[10];
        this.lateFeeCount = 0;
    }

    public void pay(double amount) {
        if (amount > 0) {
            this.balanceDue -= amount;
        }
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public static int getTicketsIssued() {
        return ticketsIssued;
    }

    public String printTicket() {
        if (attendeeId != null && attendeeId.startsWith("STU")) {
            return "Standard Event Ticket | Balance Due: " + balanceDue;
        }
        return "Standard | Balance: " + balanceDue;
    }

    protected void applyLateFee(double amount) {
        if (amount > 0) {
            this.balanceDue += amount;
            if (lateFeeCount < lateFeeHistory.length) {
                lateFeeHistory[lateFeeCount++] = amount;
            }
        }
    }

    public double[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public static String registerBatch(String[] attendeeIds, double basePrice) {
        int registered = 0;
        int rejected = 0;

        for (String id : attendeeIds) {
            try {
                new EventTicket(id, basePrice);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(EventTicket ticket) {
        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        } else if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        } else if (ticket instanceof WorkshopTicket) {
            return "Single-inheritance child";
        }
        return "Root base class";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {
        double total = 0.0;
        for (EventTicket ticket : tickets) {
            if (ticket != null) {
                total += ticket.getBalanceDue();
            }
        }
        return total;
    }

    public static String batchPrint(EventTicket[] tickets) {
        StringBuilder sb = new StringBuilder();
        for (EventTicket ticket : tickets) {
            if (ticket != null) {
                sb.append(ticket.printTicket());
                if (ticket instanceof WorkshopTicket) {
                    WorkshopTicket wt = (WorkshopTicket) ticket;
                    sb.append(" [Track via downcast: ").append(wt.getTrack()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static boolean isValidPromoCode(String code) {
        if (code == null || code.length() != 5) {
            return false;
        }
        if (code.charAt(0) != 'F') {
            return false;
        }
        for (int i = 1; i <= 3; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return false;
            }
        }
        char lastChar = code.charAt(4);
        return Character.isLetter(lastChar) && Character.isUpperCase(lastChar);
    }

    public static String processNightlySettlement(EventTicket[] tickets) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (EventTicket ticket : tickets) {
            if (ticket == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (ticket instanceof GroupTicket) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}
