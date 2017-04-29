package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.MathTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main{

    public static void main(String[] args) {

        MathTasks task1 = new MathTasks(100,5,0);
        MathTasks task2 = new MathTasks(100,5,1);
        MathTasks task3 = new MathTasks(100,5,2);


        ExecutorService service = Executors.newCachedThreadPool();



        List<Callable<Integer>> callableList = new ArrayList<>();

        callableList.add(task1);
        callableList.add(task2);
        callableList.add(task3);

        try {
            List<Future<Integer>> futureList = service.invokeAll(callableList);

            service.shutdown();
            for (Future<Integer> future : futureList) {
                try {
                    System.out.printf("Result = %s\n",future.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
