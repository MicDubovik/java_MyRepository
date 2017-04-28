package ru.job4j.MultiThreading.Wait.ProducerConsumer;

/**
 * Class buffer for numbers.
 */
public class Buffer {
    /**
     * Temp field.
     */
    private int number;

    /**
     * Constructor.
     */
    public Buffer() {
        this.number = 0;
    }

    /**
     * Synchronized method for put number into buffer.
     * @return
     */
    public synchronized boolean put() {
        while (number > 2) {
            try {
                System.out.println("Wait number from producer");
                wait();
                System.out.println("Put number in buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        this.number++;
        notify();

        return true;
    }

    /**
     * Synchronized method for get number from buffer.
     * @return
     */
    public synchronized boolean get() {
        while (number < 1) {
            try {
                System.out.println("Wait number from buffer");
                wait();
                System.out.println("Take number from buffer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        this.number--;

        notify();

        return true;
    }


}
