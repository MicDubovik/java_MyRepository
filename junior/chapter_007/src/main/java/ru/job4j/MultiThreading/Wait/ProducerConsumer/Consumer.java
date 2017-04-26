package ru.job4j.MultiThreading.Wait.ProducerConsumer;

/**
 * Class Consumer . Getting numbers.
 */
public class Consumer implements Runnable {
    /**
     * Fielad Buffer.
     */
    Buffer buffer;
    /**
     * Field for put number.
     */
    int number;

    /**
     * Constructor.
     * @param buffer
     */
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Method second thread for getting  numbers from buffer.
     */
    @Override
    public void run() {
        System.out.println("Start thread consumer");
        while (number<10)
           if (buffer.get() ){
            number++;
        }
    }
}

