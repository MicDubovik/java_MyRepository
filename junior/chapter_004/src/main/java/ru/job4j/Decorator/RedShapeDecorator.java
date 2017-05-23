package ru.job4j.Decorator;

/**
 * RedShapeDecorator
 */
public class RedShapeDecorator extends ShapeDecorator {
    /**
     * Constructor.
     * @param decoratedShape
     */
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    /**
     * Draw.
     */
    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    /**
     * SetRedBorder.
     * @param decoratedShape
     */
    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
