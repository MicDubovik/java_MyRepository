package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;

import java.nio.file.Path;

import java.util.Map;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Katy on 03.05.2017.
 */
public class Buffer {
    /**
     * Map for our files.
     */
    Map<Path, String> paths;
    /**
     * Locker.
     */
    ReentrantLock locker;

    /**
     * Temp variable for task.
     */
    private Content task;

    /**
     * Constructor.
     */
    public Buffer(ReentrantLock locker) {

        this.paths = new ConcurrentHashMap<>();
        this.task = new Content();
        this.locker = locker;

    }

    /**
     * Synchronized get temp task.
     * @return
     */
    public Content getTask() {
        synchronized (this) {
            return task;
        }
    }

    /**
     * Synchronized method  getting tasks from buffer for workers.
     *
     * @return
     */
    public boolean get() {

        locker.lock();

        for (Map.Entry<Path, String> path : paths.entrySet()) {
            this.task.setName(path.getKey());
            this.task.setContext(path.getValue());
            break;
        }
        paths.remove(task.getName());

        locker.unlock();

        return true;
    }
}

