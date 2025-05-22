package com.concurrency.synchronized_.deadLock;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("Method 1");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("Method 2");
            }
        }
    }
}
