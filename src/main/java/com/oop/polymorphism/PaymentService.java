package com.oop.polymorphism;

public class PaymentService {
    public void executePayment(PaymentProcessor processor, double amount) {
        if (processor.processPayment(amount)) {
            System.out.println("Payment successful. Details: " + processor.getPaymentDetails());
        } else {
            System.out.println("Payment failed.");
        }
    }
}
