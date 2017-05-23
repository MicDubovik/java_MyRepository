package ru.job4j.MapForBank;

/**
 * MenuOutExeption.
 */
public class MenuOutExeption extends RuntimeException {
    /**
     * Constructor.
     * @param msg
     */
    public MenuOutExeption(String msg) {
        super(msg);
    }
}
