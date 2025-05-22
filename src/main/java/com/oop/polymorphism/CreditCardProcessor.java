package com.oop.polymorphism;

public class CreditCardProcessor implements PaymentProcessor {
    private final String cardNumber;

    public CreditCardProcessor(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        // شبیه‌سازی پردازش پرداخت
        System.out.println("Processing credit card payment of $" + amount);
        return true;
    }

    @Override
    public String getPaymentDetails() {
        return "Credit Card: ****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
