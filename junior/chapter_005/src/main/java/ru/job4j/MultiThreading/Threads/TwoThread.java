package ru.job4j.MultiThreading.Threads;

public class TwoThread  {

    Arguments arguments = new Arguments();
    Thread one = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Start count words.");
            arguments.wordCount(arguments.getString());
            System.out.printf("Amounts words : %s%n", arguments.wordCount(arguments.getString()));
            System.out.printf("Stop count words.%n");
        }
    });
    Thread two = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Start count spaces .");
            System.out.printf("Amounts spaces : %s%n", arguments.spaceCount(arguments.getString()));
            System.out.println("Stop count spaces .");
        }
    });

    public static void main(String[] args) {

        TwoThread threads = new TwoThread();

        threads.one.start();
        threads.two.start();

        try {
            threads.one.join();
            threads.two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" End work all threads");

    }

}
