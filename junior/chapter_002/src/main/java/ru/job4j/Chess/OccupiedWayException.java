package ru.job4j.Chess;

/**
 * Создаем собственный класс указатель на ошибку
 * если путь занят.
 */
public class OccupiedWayException extends Exception {

    public OccupiedWayException(String message) {
        super(message);
    }
}
