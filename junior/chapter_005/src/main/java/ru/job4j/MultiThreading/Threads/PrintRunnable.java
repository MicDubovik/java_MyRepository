package ru.job4j.MultiThreading.Threads;

/**
 * PrintRunnable.
 */
class PrintRunnable implements Runnable {
    /**
     * msg.
     */
    private String msg;
    /**
     * Time for sleep.
     */
    private long sleepMillis;

    /**
     * PrintRunnable.
     * @param msg
     * @param sleepMillis
     */
    public PrintRunnable(String msg, long sleepMillis) {
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    /**
     * Run.
     */
    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
        }
    }
}
