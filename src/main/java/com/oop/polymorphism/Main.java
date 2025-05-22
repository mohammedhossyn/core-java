package com.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        PaymentProcessor creditCard = new CreditCardProcessor("1234-5678-9012-3456");
        PaymentProcessor crypto = new CryptoProcessor("1A2b3C4d5E6f7G8h9J0k");

        service.executePayment(creditCard, 100.0);
        service.executePayment(crypto, 50.0);
    }
}
