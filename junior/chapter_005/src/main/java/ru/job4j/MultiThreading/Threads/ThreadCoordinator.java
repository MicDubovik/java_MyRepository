package ru.job4j.MultiThreading.Threads;

/**
 * ThreadCoordinator.
 */
public class ThreadCoordinator {
    /**
     * runCoordinator.
     * @param print
     */
    public void runCoordinator(Runnable print) {
        print.run();
    }

    /**
     * createThread.
     * @param print
     * @return
     */
    public Thread createThread(Runnable print) {
      return   new Thread(print);
    }

    /**
     * joinThread.
     * @param thread
     */
    public void joinThread(Thread thread) {
        try {
           thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * main.
     * @param args
     * @throws InterruptedException
     */
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

    }
}
