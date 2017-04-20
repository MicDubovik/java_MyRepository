package ru.job4j.MultiThreading.MonitoreSynchronizy.First;

public class SynchronizeCounter {
    /**
     * Value number.
     */

     long value ;

    /**
     * Metod value++.
     */
    public  void  increment() {
        synchronized (this){
            this.value++;
        }


    }

    /**
     * Get value.
     * @return
     */
    public long getValue() {
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
