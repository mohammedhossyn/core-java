package com.oop.compare.abstractionVsInhertance;

// وراثت: کلاس Car از Vehicle ارث می‌بره
class Car extends Vehicle implements Fuelable {
    public Car(String brand, double speed) {
        super(brand, speed);
    }

    @Override
    public void move() {
        System.out.println(brand + " car is driving at " + speed + " km/h");
    }

    @Override
    public void refuel() {
        System.out.println(brand + " car is refueling with gasoline");
    }
}
