package ru.job4j.Chess;

/**
 * оздаем собственный класс указатель на ошибку
 * если фигура не может так передвигаться.
 */
public class ImpossibleMoveException extends Exception {

    public ImpossibleMoveException(String ime) {
        super(ime);
    }
}
