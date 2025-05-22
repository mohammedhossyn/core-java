package com.oop.inheritance;


public abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea(); // متد انتزاعی
    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }
}

