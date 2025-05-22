package com.concurrency.synchronized_.inventoryManager;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InventoryManager {
    private final Map<String, AtomicInteger> inventory;
    private final Object lock = new Object(); // قفل برای همگام‌سازی

    public InventoryManager() {
        this.inventory = new HashMap<>();
    }

    // اضافه کردن محصول به انبار
    public void addItem(String itemId, int quantity) {
        synchronized (lock) {
            inventory.compute(itemId, (key, value) -> {
                if (value == null) {
                    return new AtomicInteger(quantity);
                } else {
                    value.addAndGet(quantity);
                    return value;
                }
            });
            System.out.println(Thread.currentThread().getName() + " added " + quantity + " of " + itemId);
            lock.notifyAll(); // اطلاع به نخ‌های منتظر
        }
    }

    // برداشتن محصول از انبار
    public boolean removeItem(String itemId, int quantity) throws InterruptedException {
        synchronized (lock) {
            while (true) {
                AtomicInteger current = inventory.get(itemId);
                if (current == null || current.get() < quantity) {
                    System.out.println(Thread.currentThread().getName() + " waiting for " + itemId);
                    lock.wait(); // منتظر می‌مونه تا موجودی کافی بشه
                    continue;
                }
                current.addAndGet(-quantity);
                System.out.println(Thread.currentThread().getName() + " removed " + quantity + " of " + itemId);
                return true;
            }
        }
    }

    // گرفتن موجودی فعلی
    public int getStock(String itemId) {
        synchronized (lock) {
            AtomicInteger current = inventory.get(itemId);
            return current != null ? current.get() : 0;
        }
    }
}

