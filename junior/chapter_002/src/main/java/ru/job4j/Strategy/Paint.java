package ru.job4j.Strategy;

/**
 * Created by Katy on 02.03.2017.
 */
public class Paint {
    Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }
    public String selectDraw(){
       return shape.draw();
    }
}
