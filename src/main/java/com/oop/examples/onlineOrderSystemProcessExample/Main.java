package com.oop.examples.onlineOrderSystemProcessExample;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("P001", "Laptop", 1000.0, 2);
        Cart cart = new DiscountedCart("C001", 0.1); // 10% تخفیف
        cart.addItem(product1, 2);
        Cart cart1 = new DiscountedCart("C002", 0.1); // 10% تخفیف
        cart.addItem(product1, 2);

        PaymentProcessor processor = new CreditCardProcessor();
        OrderSystem system = new OrderSystem(processor);

        // شبیه‌سازی چندنخی برای ثبت سفارش
        Runnable orderTask = () -> system.placeOrder(cart);
        Runnable orderTask1 = () -> system.placeOrder(cart1);

        Thread t1 = new Thread(orderTask, "Thread-1");
        Thread t2 = new Thread(orderTask1, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}