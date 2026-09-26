package system_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class SmartCard {
    private String cardId;
    private PricingPlan plan;
    private double balance;
    private boolean blocked;
    private List<Transaction> transactions;

    public SmartCard(String cardId, PricingPlan plan) {
        this.cardId = cardId;
        this.plan = plan;
        this.balance = 0.0;
        this.blocked = false;
        this.transactions = new ArrayList<>();
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean topUp(double amount) {
        if (blocked) {
            System.out.printf("Card %s is blocked. Transaction rejected.%n", cardId);
            return false;
        }
        if (amount < 100.0) {
            System.out.println("Top-up rejected: Minimum top-up is \u20B9100.00.");
            return false;
        }
        if (balance + amount > 5000.0) {
            System.out.println("Top-up rejected: Maximum balance limit of \u20B95,000.00 exceeded.");
            return false;
        }
        transactions.add(new Transaction("TOP_UP", "Top Up", amount));
        balance += amount;
        System.out.printf("%s topped up with \u20B9%.2f. Balance: \u20B9%.2f.%n", cardId, amount, balance);
        return true;
    }

    public boolean purchase(String item, double price) {
        if (blocked) {
            System.out.printf("Card %s is blocked. Transaction rejected.%n", cardId);
            return false;
        }
        double finalPrice = plan.applyDiscount(price);
        if (balance < finalPrice) {
            System.out.printf("Purchase failed: Insufficient balance (\u20B9%.2f) for %s (\u20B9%.2f).%n", balance, item, finalPrice);
            return false;
        }
        balance -= finalPrice;
        transactions.add(new Transaction("PURCHASE", item, -finalPrice));
        System.out.printf("%s purchased for \u20B9%.2f. Balance: \u20B9%.2f.%n", item, finalPrice, balance);
        return true;
    }

    public boolean refund(String item) {
        if (blocked) {
            System.out.printf("Card %s is blocked. Transaction rejected.%n", cardId);
            return false;
        }
        Transaction target = null;
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            if (t.getType().equals("PURCHASE") && t.getDescription().equals(item)) {
                target = t;
                break;
            }
        }
        if (target == null) {
            System.out.printf("Refund rejected: No purchase record for %s found.%n", item);
            return false;
        }
        if (target.isRefunded()) {
            System.out.printf("Refund rejected: %s has already been refunded.%n", item);
            return false;
        }
        target.setRefunded(true);
        double refundAmount = Math.abs(target.getAmount());
        balance += refundAmount;
        transactions.add(new Transaction("REFUND", "Refund: " + item, refundAmount));
        System.out.printf("Refund of \u20B9%.2f for %s processed. Balance: \u20B9%.2f.%n", refundAmount, item, balance);
        return true;
    }

    public String getMiniStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Mini Statement for ").append(cardId).append(" (").append(plan.getPlanName()).append(") ---\n");
        for (Transaction t : transactions) {
            sb.append(String.format("%-10s | %-15s | %+.2f\n", t.getType(), t.getDescription(), t.getAmount()));
        }
        sb.append(String.format("Current Balance: \u20B9%.2f\n", balance));
        return sb.toString();
    }

    public double getBalance() {
        return balance;
    }

    public String getCardId() {
        return cardId;
    }
}
