package com.oop.examples.onlineOrderSystemProcessExample;

import java.util.ArrayList;
import java.util.List;

// کپسوله‌سازی و چندریختی: سیستم سفارش
class OrderSystem {
    private final PaymentProcessor paymentProcessor;
    private final List<Cart> carts = new ArrayList<>();

    public OrderSystem(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public synchronized void placeOrder(Cart cart) {
        double total = cart.calculateTotal();
        if (paymentProcessor.process(total)) {
            carts.add(cart);
            System.out.println("Order placed for cart: " + cart.cartId);
        } else {
            System.out.println("Payment failed for cart: " + cart.cartId);
        }
    }
}
