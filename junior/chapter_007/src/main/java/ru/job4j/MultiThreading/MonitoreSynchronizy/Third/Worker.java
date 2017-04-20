package ru.job4j.MultiThreading.MonitoreSynchronizy.Third;

import java.util.concurrent.Callable;

public class Worker implements Callable<Long> {

    CallableCounter counter = new CallableCounter();
    @Override
    public Long call() throws Exception {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }

        return counter.getValue();
    }
}
