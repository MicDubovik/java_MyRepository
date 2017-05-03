package ru.job4j.MultiThreading.Bomberman.MIniTask;

import java.util.concurrent.locks.Lock;

/**
 * Synchronized locker !!!
 */
public class Cell {
    /**
     * Fields.
     */
    private int x;
    private int y;

    /**
     * Constructor.
     * @param x
     * @param y
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Synchronized method GetX.
     * @return
     */
    public   int getX() {

            System.out.println("Come X"+Thread.currentThread().getName());
            synchronized (this){
                System.out.println("sleep X"+Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Wake up X"+Thread.currentThread().getName());
            return x;
        }

    }

    /**
     * Synchronized method GetY.
     * @return
     */
    public   int getY() {
        System.out.println("Come Y" + Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("sleep Y" + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Wake up Y" + Thread.currentThread().getName());
            return y;
        }
    }

    public static void main(String[] args) {

        /**
         * Array Cells.
         */
        Cell[]  cells = new Cell[64];
        int k = 0;
        int j = 1;

        for (int i = 0; i < cells.length; i++) {
            j++;
            if (i % 8 == 0) {
                k++;
                j = 1;
            }
            cells[i] = new Cell(k, j);
        }
        /**
         * First thread.
         */
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start "+ Thread.currentThread().getName());
                 System.out.println("one X "+cells[10].getX());
                System.out.println("one Y "+cells[10].getY());
            }
        });
        /**
         * Second thread.
         */
        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start "+ Thread.currentThread().getName());
                System.out.println("two X"+cells[10].getX());
                System.out.println("two Y "+cells[10].getY());
            }
        });

        System.out.println("start main thread");
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish!!!");

    }
}
