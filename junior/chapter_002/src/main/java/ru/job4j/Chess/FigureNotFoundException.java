package ru.job4j.Chess;

/**
 * оздаем собственный класс указатель на ошибку
 * если отстутствует фигура.
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
