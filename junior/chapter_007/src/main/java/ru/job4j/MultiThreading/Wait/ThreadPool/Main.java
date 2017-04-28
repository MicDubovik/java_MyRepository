package ru.job4j.MultiThreading.Wait.ThreadPool;

public class Main {


    public static void main(String[] args) {

         QueueTasks queueAsks = new QueueTasks();
         Task task = new Task(queueAsks);
         Worker worker = new Worker(queueAsks);

         Thread one = new Thread(task);
         Thread two = new Thread(worker);

        System.out.printf("Worker complied  %s tasks\n",worker.integerList.size());

         one.start();

          two.start();

        try {
            one.join();
             two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Worker complied  %s tasks\n",worker.integerList.size());
        System.out.printf("TempList have %s tasks\n",queueAsks.getTempAsks().size());

    }
}
