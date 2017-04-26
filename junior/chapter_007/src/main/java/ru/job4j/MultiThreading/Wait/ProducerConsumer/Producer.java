package ru.job4j.MultiThreading.Wait.ProducerConsumer;

/**
 * Class for created numbers.
 */
public class Producer implements Runnable {
    /**
     * Field buffer.
     */
    Buffer buffer;
    /**
     * Field number.
     */
    int number = 10;

    /**
     * Constructor.
     * @param buffer
     */
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Method first thread for putting number into buffer.
     */
    @Override
    public void run() {
        System.out.println("Start thread producer");
        while (number > 0) {
            if (buffer.put()) {

                number--;
            }

//            System.out.println("Put number in buffer");
        }
    }
}
