package com.oop.inheritance;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(
                new Circle("Red", 5.0),
                new Rectangle("Blue", 4.0, 6.0)
        );

        shapes.forEach(shape -> {
            System.out.println(shape + ": Area=" + shape.getArea() + ", Perimeter=" + shape.getPerimeter());
        });
    }
}
