package com.oop.onlineOrderSystemProcessExample;

// چندریختی و انتزاع: پیاده‌سازی پردازش پرداخت
class CreditCardProcessor implements PaymentProcessor {
    @Override
    public boolean process(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        return true;
    }
}
