package com.oop.compare.abstractionVsInhertance;

// انتزاع: کلاس انتزاعی برای وسایل نقلیه
abstract class Vehicle {
    protected String brand;
    protected double speed;

    public Vehicle(String brand, double speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // متد انتزاعی برای حرکت
    public abstract void move();

    public String getBrand() {
        return brand;
    }
}
