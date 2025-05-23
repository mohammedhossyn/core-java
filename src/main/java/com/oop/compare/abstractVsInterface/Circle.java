package com.oop.compare.abstractVsInterface;

// کلاس Circle با وراثت و پیاده‌سازی رابط
class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(String color, int x, int y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle at (" + x + ", " + y + ")");
    }
}
