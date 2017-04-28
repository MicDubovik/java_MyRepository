package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Task implements Runnable {

    QueueTasks asks;

    Queue<Integer> taskList = new ArrayDeque<>();

    int temp=0;

    int num = 0;

    int x = 0;


    Random random = new Random();

    public Task(QueueTasks asks) {

        this.asks = asks;
    }


    public void createAsk() {

        try {
            Thread.sleep(random.nextInt(800) + 300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        x = random.nextInt(100);



        System.out.printf("%s create %s tasks\n", Thread.currentThread().getName(), num);

        if (num == 50) {
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
