package ru.job4j.Strategy;

/**
 * DrawSquare.
 */
public class DrawSquare implements Shape{
    /**
     * Drow.
     * @return
     */
    public String draw() {
        String square = "----------"+"\n"+"|        |"+"\n"+"|        |"+"\n"+"|        |"+"\n"+"----------" ;

        return square;
    }
}
