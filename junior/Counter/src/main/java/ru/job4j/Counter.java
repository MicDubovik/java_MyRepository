package ru.job4j;

/**
 * Нахождение суммы четных чисел в заданном диапазоне
 */
public class Counter {

    int counter;

    /**
     *  Метод нахождения суммы четных чисел
     * @param start начальное число
     * @param finish конечное число
     * @return
     */

    public int add(int start, int finish) {
        for (int i = start; i <=finish ; i++) {
            if (i%2==0){
                counter+=i;
            }

        }
        return counter;
    }
}
