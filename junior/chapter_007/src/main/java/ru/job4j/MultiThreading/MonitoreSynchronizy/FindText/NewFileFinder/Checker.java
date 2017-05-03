package ru.job4j.MultiThreading.MonitoreSynchronizy.FindText.NewFileFinder;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Checker for check our files.
 */
public class Checker implements Runnable {
    /**
     * Field for search.
     */
    String text;
    /**
     * Buffer reference.
     */
    Buffer buffer;
    /**
     * Map for keeping files.
     */
    Map<Path, String> map;
    /**
     * Boolean flaf.
     */
    boolean interrupt = false;


    /**
     * Constructor.
     *
     * @param text
     * @param buffer
     */
    public Checker(String text, Buffer buffer) {
        this.text = text;
        this.buffer = buffer;
        this.map = new HashMap<>();
    }

    /**
     * Method for check content.
     *
     * @param content
     */
    public void checker(Content content) {

        if (content.getContext().contains(text)) {
            if (Thread.currentThread().isInterrupted()) {

                return;

            }

            System.out.printf("%s - found file with content %s \n File: %s\n", Thread.currentThread().getName(), text, content.getName().toAbsolutePath());
            interrupt = true;

            Thread.currentThread().interrupt();

        }


    }


    @Override
    public void run() {
        System.out.println("Start checker");
        while (buffer.paths.size() > 0 && !interrupt) {

            boolean up = buffer.get();
            if (up) {
                Content content = new Content();
                content.setName(buffer.getTask().getName());
                content.setContext(buffer.getTask().getContext());

                checker(content);
            }
        }
    }
}
