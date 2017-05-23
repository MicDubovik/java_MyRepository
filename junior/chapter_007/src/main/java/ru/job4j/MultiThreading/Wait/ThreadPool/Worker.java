package ru.job4j.MultiThreading.Wait.ThreadPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Worker.
 */
public class Worker implements Runnable {
    /**
     * QueueTasks.
     */
    QueueTasks asks;

    /**
     * List<Integer>.
     */
    List<Integer> integerList = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param asks
     */
    public Worker(QueueTasks asks) {

        this.asks = asks;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        while (!asks.flag || asks.getTempAsks().size() > 0) {
            if (integerList.size() <= 10) {
                if (asks.get()) {

                    integerList.add(asks.getTempAsks().poll());
                }
            }
        }
    }
}