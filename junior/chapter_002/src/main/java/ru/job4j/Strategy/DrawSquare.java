package ru.job4j.Strategy;

/**
 * Created by Katy on 02.03.2017.
 */
public class DrawSquare implements Shape{
    public String draw() {
        String square = "----------"+"\n"+"|        |"+"\n"+"|        |"+"\n"+"|        |"+"\n"+"----------" ;

        return square;
    }
}
