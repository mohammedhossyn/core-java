package com.oop.compare.abstractionVsInhertance;

import java.util.ArrayList;
import java.util.List;

// استفاده از انتزاع و وراثت
public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        Car car = new Car("Toyota", 120);
        Bicycle bicycle = new Bicycle("Trek", 20);
        vehicles.add(car);
        vehicles.add(bicycle);

        // استفاده از انتزاع: کار با اشیاء از طریق رابط Vehicle
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }

        // استفاده از رابط Fuelable فقط برای اشیاء مناسب
        Fuelable fuelable = car;
        fuelable.refuel();
    }
}
