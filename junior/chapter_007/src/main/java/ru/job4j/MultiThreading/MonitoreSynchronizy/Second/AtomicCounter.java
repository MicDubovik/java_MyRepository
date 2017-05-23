package ru.job4j.MultiThreading.MonitoreSynchronizy.Second;

import ru.job4j.MultiThreading.MonitoreSynchronizy.First.MyRunnable;
import ru.job4j.MultiThreading.MonitoreSynchronizy.First.SynchronizeCounter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicCounter.
 */
public class AtomicCounter {
    /**
     * Value number.
     */

    AtomicLong value = new AtomicLong();

    /**
     * Metod value++.
     */
    public  void  increment() {

            this.value.getAndIncrement();
    }

    /**
     * Get value.
     * @return
     */
    public AtomicLong getValue() {
        return value;
    }

    /**
     * Main method for start threads.
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Create object counter.
         */
        SynchronizeCounter counter = new SynchronizeCounter();
        /**
         * Create 1000 thread and start .
         */
        for (int i = 0; i < 1000; i++) {
            new Thread(new MyRunnable(counter)).start();
        }


        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * Get our result.
         */
        System.out.println("Waiting value : 1 000 000");
        System.out.println("Result : "+counter.getValue());

    }
}
