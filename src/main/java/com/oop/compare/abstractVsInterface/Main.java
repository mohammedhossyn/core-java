package com.oop.compare.abstractVsInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Circle circle = new Circle("Red", 10, 20, 5.0);
        Rectangle rectangle = new Rectangle("Blue", 30, 40, 10.0, 20.0);
        shapes.add(circle);
        shapes.add(rectangle);

        // استفاده از کلاس انتزاعی
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.getArea());
            shape.move(50, 60);
        }

        // استفاده از رابط
        List<Drawable> drawables = Arrays.asList(circle, rectangle);
        for (Drawable drawable : drawables) {
            drawable.draw();
            drawable.describe();
        }
    }
}
