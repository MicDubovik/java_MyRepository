package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTasks {
    /**
     * Temp buffer list.
     */
    private BlockingQueue<Integer> tempTasks;
    /**
     * Boolean flag for stop execute.
     */
    boolean flag = false;
    /**
     * Variable for count tasks.
     */
    int i = 0;
    /**
     * Temp variable for task.
     */
    private int task = 0;

    /**
     * Constructor.
     */
    public QueueTasks() {

        this.tempTasks = new LinkedBlockingQueue<>();

    }

    /**
     * Get for list tasks.
     * @return
     */
    public Queue<Integer> getTempAsks() {
        return tempTasks;
    }

    public synchronized int getTask() {
        return task;
    }


    /**
     * Synchronized method putting task into buffer.
     *
     * @return
     */
    public   boolean put() {
        synchronized (this) {

             notify();

            return true;
        }
    }

    /**
     * Synchronized method  getting tasks from buffer for workers.
     *
     * @return
     */
    public   boolean get() {
        synchronized (this) {
            while (this.tempTasks.size() < 1) {
                try {
                    System.out.printf("%s  Wait ask from buffer\n", Thread.currentThread().getName());
                    wait();
                    System.out.println("Wake up  " + Thread.currentThread().getName());
                    return false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            task = tempTasks.poll();
            i++;
            System.out.printf("%s get %s task\n", Thread.currentThread().getName(), i);
            System.out.printf("%s Remove %s task\n", Thread.currentThread().getName(), i);
             notify();
            return true;
        }
    }
}
