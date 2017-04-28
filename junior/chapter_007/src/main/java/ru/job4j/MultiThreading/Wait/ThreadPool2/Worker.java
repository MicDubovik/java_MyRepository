package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.ArrayList;
import java.util.List;

public class Worker implements Runnable {

    QueueTasks asks;


    List<Integer> integerList = new ArrayList<>();


    public Worker(QueueTasks asks) {

        this.asks = asks;
    }


    @Override
    public void run() {
        while (!asks.flag || asks.getTempAsks().size()>0) {

            boolean flag = asks.get();
            if (flag) {
                integerList.add(asks.getTask());

            }
        }
    }
}
