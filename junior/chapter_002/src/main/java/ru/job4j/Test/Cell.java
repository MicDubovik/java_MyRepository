package ru.job4j.Test;

/**
 * Created by Katy on 05.03.2017.
 */
public class Cell {
    int x;
    int y;
    String status;


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x<=8)
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y<=8)
        this.y = y;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
