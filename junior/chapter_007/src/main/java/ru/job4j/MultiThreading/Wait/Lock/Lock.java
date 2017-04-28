package ru.job4j.MultiThreading.Wait.Lock;

public class Lock {

    private boolean lock = false;

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
    public void unlocking(){
        synchronized (this){
            this.lock =false;
            notifyAll();
        }
    }
}
