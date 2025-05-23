package com.oop.compare.abstractVsInterface;

// کلاس انتزاعی برای اشکال
abstract class Shape {
    protected String color;
    protected int x, y;

    public Shape(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // متد انتزاعی
    public abstract double getArea();

    // متد معمولی
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        System.out.println("Moved to (" + x + ", " + y + ")");
    }
}
