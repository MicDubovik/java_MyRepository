package ru.job4j.Chess;

/**
 * Created by Katy on 05.03.2017.
 */
public class Cell {
    /**
     * Координаты ячейки массива
     */
    private int x;

    private int y;

    /**
     * Статус ячейки (свободна-занята
     */

    private String status = "empty";


    public Cell() {

    }

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

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    //    public void fillCell() {
//        this.array = new int[8][8];
//
//        int k = 10, z = 0;
//        for (int i = 0; i < 8; i++) {
//
//            for (int j = 0; j < 8; j++) {
//                if (i == 0) {
//                    this.array[i][j] = k + i + j;
//                } else {
//                    this.array[i][j] = 10 * i + i + j + k - z+1;
//                    k = +10;
//                }
//
//            }
//            z++;
//        }
//
//    }


}