package ru.job4j.MultiThreading.Bomberman.MIniTask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Share resources.
 */
public class CellLock implements Runnable{
    /**
     * Fields.
     */
    private int x;
    private int y;
    /**
     * Locker.
     */
    ReentrantLock locker;

    /**
     * Constructor.
     * @param x
     * @param y
     * @param locker
     */
    public CellLock(int x, int y, ReentrantLock locker) {
        this.x = x;
        this.y = y;
        this.locker = locker;
    }

    /**
     * Get X.
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y.
     * @return
     */
    public int getY() {
        return y;
    }

    @Override
    public void run() {

        locker.lock();

        System.out.printf("%s\n",Thread.currentThread().getName());
        System.out.printf("Y : %s\n",getY());
        System.out.printf("X : %s\n",getX());

        locker.unlock();

    }

    public static void main(String[] args) {

        ReentrantLock locker = new ReentrantLock();

        CellLock[]  cells = new CellLock[64];

        int k = 0;
        int j = 1;

        for (int i = 0; i < cells.length; i++) {
            j++;
            if (i % 8 == 0) {
                k++;
                j = 1;
            }
            cells[i] = new CellLock(k, j,locker);
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(cells[10]) ;
            thread.start();

        }


    }
}
