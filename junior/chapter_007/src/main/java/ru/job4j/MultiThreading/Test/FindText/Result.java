package ru.job4j.MultiThreading.Test.FindText;

/**
 * Class Result решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Result {
    /**
     * Result.
     */
    private boolean result = false;

    /**
     * Get result.
     * @return boolean.
     */
    public synchronized boolean isResult() {
        return result;
    }

    /**
     * Set result.
     */
    public synchronized void setResult() {
        this.result = true;
    }
}