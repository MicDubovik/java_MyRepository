package ru.job4j.MultiThreading.JMM;

/**
 * Class Counter for show count number and show problems Multithreading.
 */
public class Counter {

    SubClass subClass ;

    public Counter() {
        this.subClass =new SubClass();
    }

    /**
     * Value number.
     */
    private int value ;
    /**
     * Value = sum() from other class.
     */
    public int add() {
      return   this.value = subClass.sum();
    }

    /**
     * Value = sum() from oter class.
     */
    public int del() {

      return   this.value = subClass.sum();
    }

    public void begin() {


        System.out.println(String.format("Value after  add() in thread - %s = %s",Thread.currentThread().getName(), add()));

        System.out.println(String.format("Value after del() in thread - %s = %s",Thread.currentThread().getName(), del()));

    }

    /**
     * Main method for start threads.
     * @param args
     */
    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.begin();
                }
            }).start();
        }
    }
}
