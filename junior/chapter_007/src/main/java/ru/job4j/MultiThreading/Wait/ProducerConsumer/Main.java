package ru.job4j.MultiThreading.Wait.ProducerConsumer;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        Thread one = new Thread(producer);
        Thread two = new Thread(consumer);
        System.out.printf("Producer have : %s number \n",producer.number);

        System.out.printf("Consumer have : %s number \n",consumer.number);
        one.start();
        two.start();


        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Producer have : %s number\n",producer.number);
        System.out.printf("Consumer have : %s number\n",consumer.number);

    }
}
