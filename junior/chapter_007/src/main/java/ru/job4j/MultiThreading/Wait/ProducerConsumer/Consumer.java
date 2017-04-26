package ru.job4j.MultiThreading.Wait.ProducerConsumer;

public class Consumer implements Runnable {
    Buffer buffer;
    int number;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Start thread consumer");
        while (number<10)
           if (buffer.get() ){
            number++;
        }

//        System.out.println("Get number from buffer");
    }
}

