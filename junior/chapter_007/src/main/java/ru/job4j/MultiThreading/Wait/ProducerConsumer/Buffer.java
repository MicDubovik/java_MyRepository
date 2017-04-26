package ru.job4j.MultiThreading.Wait.ProducerConsumer;

public class Buffer {

    private int number;

    public Buffer() {
        this.number = 0;
    }

    public synchronized boolean put() {
        while (number > 1) {
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
