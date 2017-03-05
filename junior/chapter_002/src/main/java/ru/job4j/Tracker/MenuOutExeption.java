package ru.job4j.Tracker;

/**
 * Создаем свой класс для вывода управления информацией об ошибках.
 */
public class MenuOutExeption extends RuntimeException {

    public MenuOutExeption(String msg) {
        super(msg);

    }
}
