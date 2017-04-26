package ru.job4j.MultiThreading.MonitoreSynchronizy.First;

public class MyRunnable implements Runnable {

   final SynchronizeCounter counter;

    public MyRunnable(SynchronizeCounter counter) {
        this.counter = counter ;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
//            System.out.println(Thread.currentThread().getName());
                counter.increment();

        }
    }
}
