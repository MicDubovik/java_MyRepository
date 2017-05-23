package ru.job4j.Decorator;

/**
 * ShapeDecorator.
 */
public abstract class ShapeDecorator implements Shape {
    /**
     * Shape.
     */
    protected Shape decoratedShape;

    /**
     * Constructor.
     * @param decoratedShape
     */
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    /**
     * Draw.
     */
    public void draw() {
        decoratedShape.draw();
    }
}
