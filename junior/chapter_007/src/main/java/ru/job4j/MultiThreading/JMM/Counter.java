package ru.job4j.MultiThreading.JMM;

/**
 * Class Counter for show count number and show problems Multithreading.
 */
public class Counter {

    /**
     * Value number.
     */
    private long value ;

    /**
     * Metod value++.
     */
    public void increment(){
        this.value++;
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
        Counter counter = new Counter();
        /**
         * Create 1000 thread and start .
         */
        for (int i = 0; i < 1000; i++) {
              new Thread(new SubClass(counter)).start();
        }


        try {
            Thread.currentThread().sleep(500);
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
