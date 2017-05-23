package ru.job4j.MultiThreading.JMM;

/**
 * SubClass .
 */
public class SubClass implements Runnable{
    /**
     * Count.
     */
    Counter count ;

    /**
     * Constructor.
     * @param counter
     */
    public SubClass(Counter counter) {
        this.count = counter ;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            count.increment();
        }
    }
}
