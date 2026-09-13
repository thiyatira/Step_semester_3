package inheritance_polymorphism.assigment_problems;

import java.util.Arrays;

// Base class for Riverside City Marathon entries managing bib details, payments, and late fees.
public class RaceEntry {
    private static int bibCounter = 0;

    public final String entryCode;
    protected String bibNumber;
    protected double entryFee;
    protected double balanceDue;
    private double[] lateFeeHistory;
    private int lateFeeCount;

    public RaceEntry(String bibNumber, double entryFee) {
        if (bibNumber == null || bibNumber.trim().length() < 4) {
            throw new IllegalArgumentException("Bib number must be at least 4 characters long.");
        }
        if (entryFee < 0) {
            throw new IllegalArgumentException("Entry fee cannot be negative.");
        }

        bibCounter++;
        this.entryCode = "RC-" + (1000 + bibCounter);
        this.bibNumber = bibNumber.trim();
        this.entryFee = entryFee;
        this.balanceDue = entryFee;
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

    public String getBibNumber() {
        return bibNumber;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public static int getBibCounter() {
        return bibCounter;
    }

    public String announce() {
        return "Race Entry | Bib: " + bibNumber + " | Balance: " + balanceDue;
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

    public static String registerBatch(String[] bibNumbers, double entryFee) {
        int registered = 0;
        int rejected = 0;

        for (String bib : bibNumbers) {
            try {
                new RaceEntry(bib, entryFee);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry) {
            return "Multilevel descendant (3 generations deep)";
        } else if (entry instanceof RelayTeamEntry) {
            return "Hierarchical sibling (independent branch)";
        } else if (entry instanceof RunnerEntry) {
            return "Single-inheritance child";
        }
        return "Root base class";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0.0;
        for (RaceEntry entry : entries) {
            if (entry != null) {
                total += entry.getBalanceDue();
            }
        }
        return total;
    }

    public static String announceAll(RaceEntry[] entries) {
        StringBuilder sb = new StringBuilder();
        for (RaceEntry entry : entries) {
            if (entry != null) {
                sb.append(entry.announce());
                if (entry instanceof RelayTeamEntry) {
                    RelayTeamEntry rte = (RelayTeamEntry) entry;
                    sb.append(" [Team size via downcast: ").append(rte.getTeamSize()).append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5) {
            return false;
        }
        if (code.charAt(0) != 'M') {
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

    public static String settleNight(RaceEntry[] entries) {
        int processed = 0;
        int nullSkipped = 0;
        int relay = 0;
        int individual = 0;

        for (RaceEntry entry : entries) {
            if (entry == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (entry instanceof RelayTeamEntry) {
                relay++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + relay + " relay | " + individual + " individual";
    }
}
