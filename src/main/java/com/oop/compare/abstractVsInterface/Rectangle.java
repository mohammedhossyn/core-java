package com.oop.compare.abstractVsInterface;

// کلاس Rectangle با وراثت و پیاده‌سازی رابط
class Rectangle extends Shape implements Drawable {
    private double width, height;

    public Rectangle(String color, int x, int y, double width, double height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle at (" + x + ", " + y + ")");
    }
}
