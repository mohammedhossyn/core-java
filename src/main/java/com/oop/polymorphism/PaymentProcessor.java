package com.oop.polymorphism;

public interface PaymentProcessor {
    boolean processPayment(double amount);
    String getPaymentDetails();
}

