package ru.job4j.Decorator;

/**
 * Rectangle.
 */
public class Rectangle implements Shape {
    /**
     * draw.
     */
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
