package ru.job4j.Strategy;

/**
 * Strategy.
 */
public class StartStrategy {
    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint(new DrawSquare());
        Paint paint2 = new Paint(new DrawTriangle());
        System.out.println(paint.shape.draw());
        System.out.println(paint2.shape.draw());
    }

}
