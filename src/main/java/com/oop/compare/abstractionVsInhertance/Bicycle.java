package com.oop.compare.abstractionVsInhertance;

// وراثت: کلاس Bicycle از Vehicle ارث می‌بره
class Bicycle extends Vehicle {
    public Bicycle(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(brand + " bicycle is pedaling at " + speed + " km/h");
    }
}
