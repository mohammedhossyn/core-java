package com.concurrency.lockApi.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PrintQueue {
    private final ReentrantLock lock = new ReentrantLock(true); // قفل عادلانه
    private final Condition printerAvailable = lock.newCondition();
    private boolean isPrinterBusy = false;

    public boolean printJob(String jobName) {
        // تلاش برای گرفتن قفل با زمان انتظار 1 ثانیه
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    while (isPrinterBusy) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " waiting for printer");
                            printerAvailable.await(); // منتظر آزاد شدن پرینتر
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return false;
                        }
                    }
                    isPrinterBusy = true;
                    System.out.println(Thread.currentThread().getName() + " printing: " + jobName);
                    Thread.sleep(1000); // شبیه‌سازی چاپ
                    isPrinterBusy = false;
                    printerAvailable.signalAll(); // اطلاع به نخ‌های منتظر
                    return true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock for " + jobName);
                return false;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}