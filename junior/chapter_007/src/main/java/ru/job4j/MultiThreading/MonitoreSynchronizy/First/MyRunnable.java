package ru.job4j.MultiThreading.MonitoreSynchronizy.First;

/**
 * MyRunnable.
 */
public class MyRunnable implements Runnable {
    /**
     * SynchronizeCounter.
     */
   final SynchronizeCounter counter;

    /**
     * Constructor.
     * @param counter
     */
    public MyRunnable(SynchronizeCounter counter) {
        this.counter = counter ;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
//            System.out.println(Thread.currentThread().getName());
                counter.increment();

        }
    }
}
