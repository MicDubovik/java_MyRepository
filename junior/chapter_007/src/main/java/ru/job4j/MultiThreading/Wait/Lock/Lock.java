package ru.job4j.MultiThreading.Wait.Lock;

/**
 * Locker.
 */
public class Lock {
    /**
     * boolean lock.
     */
    private boolean lock = false;

    /**
     * lockin.
     */
    public void locking() {
        synchronized (this) {
            while (lock) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.lock = true;
        }
    }

    /**
     * unlocking.
     */
    public void unlocking(){
        synchronized (this){
            this.lock =false;
            notifyAll();
        }
    }
}
