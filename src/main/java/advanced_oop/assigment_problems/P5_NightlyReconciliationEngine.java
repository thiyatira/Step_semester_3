package advanced_oop.assigment_problems;

// Question 5: nightly batch reconciliation engine
public class P5_NightlyReconciliationEngine {

    public void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        if(account == null) {
            System.out.println("Cannot process null account.");
            return;
        }

        double fee;
        if(account instanceof PremiumAccount) {
            fee = ((PremiumAccount) account).getDiscountedSurgeFee(delayMinutes);
            System.out.printf("Processed Premium Account [%s]: Amount Rs %.1f, Delay %d mins -> Surge Fee: Rs %.2f%n",
                    account.getStudentId(), amount, delayMinutes, fee);
        } else {
            fee = account.calculateSurgeFee(delayMinutes);
            System.out.printf("Processed Regular Account [%s]: Amount Rs %.1f, Delay %d mins -> Surge Fee: Rs %.2f%n",
                    account.getStudentId(), amount, delayMinutes, fee);
        }
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if(accounts == null || amounts == null || delayMinutesArray == null) {
            System.out.println("Invalid batch input.");
            return;
        }

        int n = accounts.length;
        if(amounts.length != n || delayMinutesArray.length != n) {
            System.out.println("Warning: array length mismatch.");
            n = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));
        }

        int processed = 0;
        int nullSkipped = 0;
        int premium = 0;
        int regular = 0;
        double totalSurge = 0.0;

        // single pass O(1) space
        for(int i = 0; i < n; i++) {
            DeliveryAccount acc = accounts[i];
            if(acc == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            int delay = delayMinutesArray[i];

            // instanceof check to decide settlement
            if(acc instanceof PremiumAccount) {
                premium++;
                double fee = ((PremiumAccount) acc).getDiscountedSurgeFee(delay);
                totalSurge += fee;
            } else {
                regular++;
                double fee = acc.calculateSurgeFee(delay);
                totalSurge += fee;
            }
        }

        System.out.printf("%d processed | %d null skipped | %d premium | %d regular | grand total surge fees = Rs %.1f%n",
                processed, nullSkipped, premium, regular, totalSurge);
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutesArray = {10, 5, 0};

        System.out.println("Running nightly reconciliation batch:");
        processBatch(accounts, amounts, delayMinutesArray);
    }
}
