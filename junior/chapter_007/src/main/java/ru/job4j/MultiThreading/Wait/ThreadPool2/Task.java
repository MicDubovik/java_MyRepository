package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.Random;

/**
 * Task.
 */
public class Task implements Runnable {
    /**
     * Field for contact with buffer(QueueTasks).
     */
    QueueTasks asks;
    /**
     * Counter tasks.
     */
    int num = 0;
    /**
     * Variable for task and for add task into buffer.
     */
    int x =0;

    Random random = new Random();

    /**
     * Constructor.
     * @param asks
     */
    public Task(QueueTasks asks) {

        this.asks = asks;
    }

    /**
     * Creator for tasks.
     */
    public void createAsk() {

        try {
            Thread.sleep(random.nextInt(800) + 300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        x = random.nextInt(100);



        System.out.printf("%s create %s tasks\n", Thread.currentThread().getName(), num);

        if (num == 10) {
            asks.flag = true;
        }

    }


    @Override
    public void run() {

        while (!asks.flag) {
            createAsk();
            boolean flag = asks.put();
            if (flag) {
                System.out.printf("%s Add task %s to buffer\n", Thread.currentThread().getName(), num);
                asks.getTempAsks().add(x);
            }

        }
    }
}
