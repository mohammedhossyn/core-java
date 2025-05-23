package com.oop.isA_and_hasA.compare;

// زیرکلاس Car با وراثت (Is-A) و ترکیب (Has-A)
class Car extends Vehicle {
    private Engine engine; // رابطه Has-A

    public Car(String brand, Engine engine) {
        super(brand);
        this.engine = engine;
    }

    @Override
    public void move() {
        engine.start(); // استفاده از شیء Engine
        System.out.println(brand + " car is driving");
    }
}
