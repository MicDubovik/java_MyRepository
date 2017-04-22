package ru.job4j.MultiThreading.Test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HungryStudent {
    public static void main(String[] args) {
        int n = 4;
        ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(n);
        for(int i=0;i<n;i++){
            executor.scheduleAtFixedRate(new Kock(),i,1, TimeUnit.SECONDS);
        }
    }
}
class Kock implements Runnable {
    static public int count=0;
    private int id=count++;
    public void run() {
        System.out.println("Еда подана от Кока№"+id);
    }
}