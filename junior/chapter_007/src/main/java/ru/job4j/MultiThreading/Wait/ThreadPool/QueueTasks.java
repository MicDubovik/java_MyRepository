package ru.job4j.MultiThreading.Wait.ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTasks {
    /**
     * Temp field.
     */
    private Queue<Integer> tempTasks;

    boolean flag = false;

    final private int core;

    int i = 0;

    /**
     * Constructor.
     */
    public QueueTasks() {

        this.tempTasks = new ArrayDeque<>();
        this.core = Runtime.getRuntime().availableProcessors();
    }

    public Queue<Integer> getTempAsks() {
        return tempTasks;
    }


    /**
     * Synchronized method for put number into buffer.
     *
     * @return
     */
    public synchronized boolean put() {
        while (this.tempTasks.size() > 1) {
            try {
                System.out.println("Wait Ask from Boss");
                wait();
                System.out.println("Put ask in buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }

        notify();

        return true;
    }

    /**
     * Synchronized method for get number from buffer.
     *
     * @return
     */
    public synchronized boolean get() {
        while (this.tempTasks.size() < 1) {
            try {
                System.out.printf("%s  Wait ask from buffer\n", Thread.currentThread().getName());
                wait();
                System.out.println("Wake up  " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        i++;
        notify();
        System.out.printf("%s Remove %s task\n", Thread.currentThread().getName(), i);
        return true;
    }

}
