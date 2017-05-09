package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList;

/**
 * Создаем свой класс для вывода управления информацией об ошибках.
 */
public class MenuOutExeption extends RuntimeException {

    public MenuOutExeption(String msg) {
        super(msg);

    }
}
