package oop.class_problems;

// class problem 1: basic bank account
class BankAccount {
    private static int totalAccounts = 0;
    private static final double MIN_BALANCE = 500.0;

    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialDeposit) {
        if (initialDeposit < MIN_BALANCE) {
            throw new IllegalArgumentException("Initial deposit must be at least Rs " + MIN_BALANCE);
        }
        totalAccounts++;
        this.accountNumber = "ACC-" + (10000 + totalAccounts);
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Rs " + amount + " | New Balance: Rs " + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " | New Balance: Rs " + balance);
            return true;
        } else {
            System.out.println("Withdrawal failed: insufficient balance or below minimum threshold.");
            return false;
        }
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rahul Sharma", 5000);
        BankAccount acc2 = new BankAccount("Priya Patel", 10000);

        System.out.println("Account created: " + acc1.getAccountNumber() + " for " + acc1.getAccountHolder());
        acc1.deposit(1500);
        acc1.withdraw(2000);

        System.out.println("Account created: " + acc2.getAccountNumber() + " for " + acc2.getAccountHolder());
        System.out.println("Total bank accounts active: " + BankAccount.getTotalAccounts());
    }
}
