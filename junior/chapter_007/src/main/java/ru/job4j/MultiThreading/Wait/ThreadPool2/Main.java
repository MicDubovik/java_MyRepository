package ru.job4j.MultiThreading.Wait.ThreadPool2;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Worker> workerList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
         QueueTasks queueAsks = new QueueTasks();
         Task tasker = new Task(queueAsks);
         int num = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < num; i++) {
            workerList.add(new Worker(queueAsks));
        }


         Thread one = new Thread(tasker);

        for (int i = 0; i < workerList.size(); i++) {
            threadList.add(new Thread(workerList.get(i)));
        }



         one.start();

        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).start();
        }

        try {
            one.join();
            for (int i = 0; i < threadList.size(); i++) {
                threadList.get(i).join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < workerList.size(); i++) {
            System.out.printf("Worker complied  %s tasks\n",workerList.get(i).integerList.size());
        }

        System.out.printf("TempList have %s tasks\n",queueAsks.getTempAsks().size());

    }
}
