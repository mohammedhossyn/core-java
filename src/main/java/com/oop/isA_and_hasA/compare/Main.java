package com.oop.isA_and_hasA.compare;

public class Main {
    public static void main(String[] args) {
        Engine gasolineEngine = new Engine("Gasoline");
        Vehicle car = new Car("Toyota", gasolineEngine); // Is-A: Car is a Vehicle; Has-A: Car has an Engine
        Vehicle bicycle = new Bicycle("Trek"); // Is-A: Bicycle is a Vehicle

        car.move();
        bicycle.move();
    }
}
