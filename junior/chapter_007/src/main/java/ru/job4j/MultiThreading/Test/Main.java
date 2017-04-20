package ru.job4j.MultiThreading.Test;

public class Main {
    private static final int NTHREDS = 10;

    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().join();
    }
//        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
//        for (int i = 0; i < 500; i++) {
//            Runnable worker = new MyRunnable(10000000 + i);
//            executor.execute(worker);
//        }
//        // This will make the executor accept no new threads
//        // and finish all existing threads in the queue
//        executor.shutdown();
//        // Wait until all threads are finish
//
//        executor.awaitTermination(10,TimeUnit.SECONDS);
//        System.out.println("Finished all threads");
//    }
}