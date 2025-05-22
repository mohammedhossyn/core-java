package com.oop.polymorphism;

public class CryptoProcessor implements PaymentProcessor {
    private final String walletAddress;

    public CryptoProcessor(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public boolean processPayment(double amount) {
        // شبیه‌سازی پردازش پرداخت
        System.out.println("Processing crypto payment of $" + amount);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "Crypto Wallet: " + walletAddress;
    }
}
