package ru.job4j.MultiThreading.Test;

public class MyThread implements Runnable {

    private boolean isActive;

    void disable(){
        isActive=false;
    }

    MyThread(){
        isActive = true;
    }

    public void run(){

        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while(isActive){
            System.out.println("Цикл " + counter++);
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Поток прерван");
            }
        }
        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        System.out.println("Главный поток начал работу...");
        MyThread myThread = new MyThread();
        new Thread(myThread,"MyThread").start();

        try{
            Thread.sleep(1100);

            myThread.disable();

            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println("Поток прерван");
        }
        System.out.println("Главный поток завершил работу...");
    }
}