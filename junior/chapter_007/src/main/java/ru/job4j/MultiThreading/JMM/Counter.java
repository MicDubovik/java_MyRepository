package ru.job4j.MultiThreading.JMM;

/**
 * Class Counter for show count number and show problems Multithreading.
 */
public class Counter {
    /**
     * Value number.
     */
  private int value =0;

    /**
     * Value++.
     */
    public void add(){
        this.value++;
    }

    /**
     * Value --.
     */
    public void del(){
        this.value--;
    }

    public void begin(){

        add();
        System.out.println(String.format("Value after add()= %s",this.value));
        del();
        System.out.println(String.format("Value after del()= %s",this.value));
    }

    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.begin();
                }
            }).start();
        }
    }
}
