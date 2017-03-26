package ru.job4j.Calculator;

/**
 * Калькулятор .
 */


public class Calculator {

    /**
     * result - получаемый результат .
     */

    private double result;

    /**
     * метод сложения.
     */

    public void add(double first, double second) {

        this.result = first + second;


    }

    /**
     * метод вычитания.
     */

    public void sub(double first, double second) {


        this.result = first - second;


    }

    /**
     * метод деления.
     */

    public void div(double first, double second) {

        if (second != 0) {
            this.result = first / second;
        } else {
            this.result = 0;
        }


    }

    /**
     * метод умножения.
     */

    public void mul(double first, double second) {

        this.result = first * second;


    }

    /**
     * свойство поля результат.
     */

    public double getResult() {

        return this.result;

    }


}