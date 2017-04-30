package ru.job4j.MultiThreading.Bomberman;

public class Cell {

    private final int MAXSIZE=10;
    private final int MINSIZE=0;

    private int H;
    private int V;

    private boolean occupied =false;

    public Cell(int h, int v ) {
        H = h;
        V = v;
        this.occupied = occupied;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getMAXSIZE() {
        return MAXSIZE;
    }

    public int getMINSIZE() {
        return MINSIZE;
    }
}
