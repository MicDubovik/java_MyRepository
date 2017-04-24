package ru.job4j.MultiThreading.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class BacklogWorker extends Thread {
    /* здесь хранятся все таски на выполнение*/
    private final LinkedList<Runnable> backlog = new LinkedList<Runnable>();
    private static final int INITIAL_CAPACITY = 100;
    /* здесь хранятся таски, которые будут выполнятся */
    private final List<Runnable> workQueue = new ArrayList<Runnable>(INITIAL_CAPACITY);

    BacklogWorker(String name) {
        super(name);
    }

    /* добавить  новый таск*/
    synchronized void enque(Runnable work) {
        if (work != null) {
            backlog.add(work);
        }
        notify();
    }

    public void run() {
        while (!isInterrupted()) {
	/* добавляем все в очередь на выполнения, и отпускаем лок*/
            synchronized (this) {
                if (backlog.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
                int size = backlog.size();
                for (int i = 0; i < INITIAL_CAPACITY && i < size; i++) {
                    workQueue.add(backlog.poll());
                }
                backlog.clear();
            }
            for (Runnable task : workQueue) {
                try {
                    task.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            workQueue.clear();
        }
    }
}
