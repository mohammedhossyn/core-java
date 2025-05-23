package com.oop.examples.onlineOrderSystemProcessExample;

// انتزاع: رابط برای پردازش پرداخت
interface PaymentProcessor {
    boolean process(double amount);
}
