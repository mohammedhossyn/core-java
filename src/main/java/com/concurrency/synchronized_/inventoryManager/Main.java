package com.concurrency.synchronized_.inventoryManager;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // نخ برای اضافه کردن موجودی
        Runnable supplier = () -> {
            for (int i = 0; i < 5; i++) {
                manager.addItem("item1", 10);
                try {
                    Thread.sleep(100); // شبیه‌سازی تأخیر
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // نخ برای برداشتن موجودی
        Runnable consumer = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    manager.removeItem("item1", 7);
                    Thread.sleep(150); // شبیه‌سازی تأخیر
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // اجرای نخ‌ها
        Thread supplierThread = new Thread(supplier, "Supplier");
        Thread consumerThread1 = new Thread(consumer, "Consumer1");
        Thread consumerThread2 = new Thread(consumer, "Consumer2");

        supplierThread.start();
        consumerThread1.start();
        consumerThread2.start();

        // منتظر پایان نخ‌ها
        try {
            supplierThread.join();
            consumerThread1.join();
            consumerThread2.join();
            System.out.println("Final stock of item1: " + manager.getStock("item1"));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
