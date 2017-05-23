package ru.job4j.Decorator;

/**
 * Circle.
 */
public class Circle implements Shape {
    /**
     * Draw.
     */
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}