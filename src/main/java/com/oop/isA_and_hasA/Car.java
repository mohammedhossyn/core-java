package com.oop.isA_and_hasA;

class Car {
    private String brand;
    private Engine engine; // رابطه Has-A

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println(brand + " car is driving");
    }
}
