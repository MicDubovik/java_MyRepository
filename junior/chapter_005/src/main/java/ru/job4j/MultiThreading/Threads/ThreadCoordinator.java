package ru.job4j.MultiThreading.Threads;

public class ThreadCoordinator {

    public void runCoordinator(Runnable print) {
        print.run();
    }

    public Thread createThread(Runnable print) {
      return   new Thread(print);
    }


    public void joinThread(Thread thread) {
        try {
           thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadCoordinator coordinator = new ThreadCoordinator();

            for (int i = 0; i <5 ; i++) {
        Runnable printerA = new PrintRunnable("A   .", 100);
        Runnable printerB = new PrintRunnable(".   B", 99);
        Runnable printerC = new PrintRunnable("  C  ", 100);

       Thread a = coordinator.createThread(printerA) ;

       Thread b = coordinator.createThread(printerB);

       Thread c = coordinator.createThread(printerC);

            a.start();
            b.start();

            a.join();
            b.join();

            System.out.println("------");
            c.start();
            c.join();
            System.out.println("------");

        }


//        coordinator.createThread(printerC).start();
//        coordinator.createThread(printerC).join();
//        System.out.println("------");

    }
}
