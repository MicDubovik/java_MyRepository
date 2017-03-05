package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public class Cell {
    int x;
    int y;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static void main(String[] args) {

        Cell cell = new Cell(3,1);
//        Figure figure =new Figure();
//        figure.startposition = cell ;
//
//        figure.move(cell,new Cell(4,2));

    }
}
