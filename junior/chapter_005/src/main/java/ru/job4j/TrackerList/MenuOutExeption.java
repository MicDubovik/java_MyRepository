package ru.job4j.TrackerList;

/**
 * Создаем свой класс для вывода управления информацией об ошибках.
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
