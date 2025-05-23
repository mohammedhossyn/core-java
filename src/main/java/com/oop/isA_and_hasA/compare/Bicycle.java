package com.oop.isA_and_hasA.compare;

// زیرکلاس Bicycle با وراثت (Is-A) بدون ترکیب
class Bicycle extends Vehicle {
    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " bicycle is pedaling");
    }
}
