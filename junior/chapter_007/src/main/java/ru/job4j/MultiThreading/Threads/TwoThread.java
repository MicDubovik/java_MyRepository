package ru.job4j.MultiThreading.Threads;

public class TwoThread {
    /**
     * Input class for threads.
     */
    Arguments arguments = new Arguments();
    /**
     * Thread for count words.
     */
    Thread one = new Thread(new Runnable() {
        @Override
        public void run() {

            long startTime = System.currentTimeMillis();

            System.out.println("Start count words.");
            try {
                one.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - startTime) > 1000) {
                System.out.println(Thread.currentThread().getName()+" it's thread was interrupted");
                Thread.currentThread().interrupt();

            }
            if (Thread.currentThread().isInterrupted()){
                return;
            }
            System.out.printf("Amounts words : %s%n", arguments.wordCount( arguments.string));

            System.out.printf("Stop count words.%n");
        }
    });

    /**
     * Thread for count spaces.
     */
    Thread two = new Thread(new Runnable() {
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();

            System.out.println("Start count spaces .");
            try {
               two.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((System.currentTimeMillis() - startTime) > 1000) {
                System.out.println(Thread.currentThread().getName()+" it's thread was interrupted");
                Thread.currentThread().interrupt();
            }
            if (Thread.currentThread().isInterrupted()){
                return;
            }
             System.out.printf("Amounts spaces : %s%n", arguments.spaceCount( arguments.string));

            System.out.println("Stop count spaces .");
        }
    });

    /**
     * Main method for start program.
     * @param args
     */
    public static void main(String[] args) {

        TwoThread threads = new TwoThread();
        System.out.println("Start program");

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
