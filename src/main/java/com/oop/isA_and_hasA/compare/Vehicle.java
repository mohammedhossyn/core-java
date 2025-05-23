package com.oop.isA_and_hasA.compare;

// کلاس انتزاعی برای وسایل نقلیه (برای رابطه Is-A)
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}
