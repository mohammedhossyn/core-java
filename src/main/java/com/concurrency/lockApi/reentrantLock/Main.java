package com.concurrency.lockApi.reentrantLock;

public class Main {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();
        Runnable printTask = () -> {
            for (int i = 0; i < 3; i++) {
                String jobName = "Job-" + i;
                boolean success = queue.printJob(jobName);
                if (!success) {
                    System.out.println(Thread.currentThread().getName() + " will retry " + jobName);
                    try {
                        Thread.sleep(500); // تأخیر قبل از تلاش مجدد
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        Thread t1 = new Thread(printTask, "Thread-1");
        Thread t2 = new Thread(printTask, "Thread-2");

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
