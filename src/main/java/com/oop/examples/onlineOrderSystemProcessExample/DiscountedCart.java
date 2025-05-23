package com.oop.examples.onlineOrderSystemProcessExample;

// وراثت و چندریختی: سبد خرید با تخفیف
class DiscountedCart extends Cart {
    private final double discountRate;

    public DiscountedCart(String cartId, double discountRate) {
        super(cartId);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotal() {
        double total = items.entrySet().stream()
                .mapToDouble(entry -> {
                    // فرضاً قیمت از یه منبع خارجی
                    return entry.getValue() * 100.0; // قیمت نمونه
                })
                .sum();
        return total * (1 - discountRate);
    }
}
