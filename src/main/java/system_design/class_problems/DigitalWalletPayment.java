package system_design.class_problems;

public class DigitalWalletPayment implements IPaymentMethod {
    private String walletId;
    private boolean shouldSucceed;

    public DigitalWalletPayment(String walletId, boolean shouldSucceed) {
        this.walletId = walletId;
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() {
        return "Digital Wallet";
    }
}
