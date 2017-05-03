package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;

import java.nio.file.Path;

/**
 * Temp class for check.
 */
public class Content {
    /**
     * Content.
     */
    String context;
    /**
     * Files.
     */
    Path name;

    /**
     * Synchronized get content.
     * @return
     */
    public synchronized String getContext() {
        return context;
    }
    /**
     * Synchronized set content.
     * @return
     */
    public synchronized void setContext(String context) {
        this.context = context;
    }
    /**
     * Synchronized get PathName.
     * @return
     */
    public synchronized Path getName() {
        return name;
    }
    /**
     * Synchronized set pathName.
     * @return
     */
    public synchronized void setName(Path name) {
        this.name = name;
    }
}
