package ru.job4j.Strategy;

/**
 * DrawTriangle.
 */
public class DrawTriangle implements Shape {
    /**
     * Drow.
     * @return
     */
    public String draw(){
        String triangle ="   *"+"\n"+"  * * "+"\n"+" *   * "+"\n"+"*******";

        return triangle;

    }

}
