package com.oop.examples.onlineOrderSystemProcessExample;

import java.util.concurrent.atomic.AtomicInteger;

// کپسوله‌سازی: کلاس محصول
class Product {
    private final String id;
    private final String name;
    private final double price;
    private final AtomicInteger stock;

    public Product(String id, String name, double price, int initialStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = new AtomicInteger(initialStock);
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean reserveStock(int quantity) {
        while (true) {
            int currentStock = stock.get();
            if (currentStock < quantity) {
                return false;
            }
            if (stock.compareAndSet(currentStock, currentStock - quantity)) {
                return true;
            }
        }
    }
}
