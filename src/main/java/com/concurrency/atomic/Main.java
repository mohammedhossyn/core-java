package com.concurrency.atomic;

public class Main {
    public static void main(String[] args) {
        AtomicConfigExample example = new AtomicConfigExample();

        // چند نخ برای به‌روزرسانی تنظیمات
        Runnable updater1 = () -> example.updateConfig("highPriority", 10);
        Runnable updater2 = () -> example.updateConfig("lowPriority", 5);

        Thread t1 = new Thread(updater1, "Thread-1");
        Thread t2 = new Thread(updater2, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Final config: " + example.getConfig());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
