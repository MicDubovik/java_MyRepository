package ru.job4j.Strategy;

/**
 * Created by Katy on 02.03.2017.
 */
public class DrawTriangle implements Shape {
    public String draw(){
        String triangle ="   *"+"\n"+"  * * "+"\n"+" *   * "+"\n"+"*******";

        return triangle;

    }

}
