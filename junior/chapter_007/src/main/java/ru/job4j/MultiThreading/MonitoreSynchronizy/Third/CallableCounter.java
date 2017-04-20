package ru.job4j.MultiThreading.MonitoreSynchronizy.Third;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableCounter {
    /**
     * Value.
     */
    private long value;

    private static final int num = 10;

    /**
     * Value++.
     */
    public void increment() {
        this.value++;
    }

    /**
     * Get value.
     * @return
     */
    public long getValue() {
        return this.value;
    }

    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(num);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        for (int i = 0; i < 1000; i++) {
            Callable<Long> worker = new Worker();
            Future<Long> submit = executor.submit(worker);
            list.add(submit);
        }
        int sum = 0;
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Waiting value : 1 000 000");
        System.out.println("Result : "+sum);
        executor.shutdown();
    }
}

