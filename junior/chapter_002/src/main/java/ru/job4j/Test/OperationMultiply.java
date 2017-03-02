package ru.job4j.Test;

/**
 * Created by Katy on 02.03.2017.
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
