package ru.job4j.MultiThreading.Wait.ProducerConsumer;

public class Producer implements Runnable {
    Buffer buffer;

    int number = 10;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

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
