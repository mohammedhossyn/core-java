package com.oop.onlineOrderSystemProcessExample;

import java.util.concurrent.ConcurrentHashMap;

// وراثت: کلاس پایه برای سبد خرید
abstract class Cart {
    protected final String cartId;
    protected final ConcurrentHashMap<String, Integer> items;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.items = new ConcurrentHashMap<>();
    }

    public abstract double calculateTotal();

    public void addItem(Product product, int quantity) {
        if (product.reserveStock(quantity)) {
            items.compute(product.getId(), (key, value) -> value == null ? quantity : value + quantity);
        }
    }
}
