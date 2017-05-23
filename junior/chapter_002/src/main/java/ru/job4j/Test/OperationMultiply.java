package ru.job4j.Test;

/**
 * OperationMultiply.
 */
public class OperationMultiply implements Strategy{
    /**
     * doOperation.
     * @param num1
     * @param num2
     * @return
     */
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
