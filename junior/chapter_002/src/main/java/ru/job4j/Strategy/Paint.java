package ru.job4j.Strategy;

/**
 * Paint.
 */
public class Paint {
    /**
     * Reference to the shape.
     */
    Shape shape;

    /**
     * Constructor.
     * @param shape
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Select figure.
     * @return
     */
    public String selectDraw(){
       return shape.draw();
    }
}
