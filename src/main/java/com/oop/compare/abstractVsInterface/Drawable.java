package com.oop.compare.abstractVsInterface;

// رابط برای قابلیت رسم
interface Drawable {
    void draw();

    default void describe() {
        System.out.println("This is a drawable object");
    }
}
