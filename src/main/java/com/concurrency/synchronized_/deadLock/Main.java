package com.concurrency.synchronized_.deadLock;

public class Main {
    public static void main(String[] args) {
        DeadlockExample example = new DeadlockExample();

        // نخ اول: فراخوانی method1
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                example.method1();
            }
        }, "Thread-1");

        // نخ دوم: فراخوانی method2
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                example.method2();
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        // تشخیص Deadlock (اختیاری)
        Thread deadlockDetector = new Thread(() -> {
            try {
                Thread.sleep(1000); // صبر برای وقوع Deadlock
                if (t1.getState() == Thread.State.BLOCKED && t2.getState() == Thread.State.BLOCKED) {
                    System.out.println("Deadlock detected!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        deadlockDetector.start();

        try {
            t1.join();
            t2.join();
            deadlockDetector.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}