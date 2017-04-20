package ru.job4j.MultiThreading.JMM;

/**
 * SubClass .
 */
public class SubClass implements Runnable{
    Counter count ;

    public SubClass(Counter counter) {
        this.count = counter ;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            count.increment();
        }
    }
}
