package ru.job4j.turn;

/**
 * Задание перевернуть массив.
 */
public class Turn {
    /**
     * Метод переворачивающий значения массива в обратном порядке.
     * @param array
     * @return
     */

    public int[] back(int[] array) {
        int buffer = 0;
        int lenght = array.length - 1;
        for (int i = 0; i < lenght; i++) {
            buffer = array[i];
            array[i] = array[lenght];
            array[lenght]=buffer;
            lenght--;
        }
        return array;
    }



}

