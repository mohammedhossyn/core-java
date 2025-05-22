package com.concurrency.concurrentCollections;

public class Main {
    public static void main(String[] args) {
        OnlineUsersTracker tracker = new OnlineUsersTracker();

        Runnable visitTask = () -> {
            String userId = "User-" + Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                tracker.recordVisit(userId);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(visitTask, "A");
        Thread t2 = new Thread(visitTask, "B");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Visits for User-A: " + tracker.getVisitCount("User-A"));
            System.out.println("Visits for User-B: " + tracker.getVisitCount("User-B"));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
