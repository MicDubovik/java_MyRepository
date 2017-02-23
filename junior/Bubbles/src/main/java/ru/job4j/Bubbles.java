package ru.job4j;

/**
 * Сортировка методом пузырька
 */
public class Bubbles {
    /**
     * Реализация метода сортировки
     * @param array
     * @return
     */

    public int[] methodBubles(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int buffer = array[i];
                    array[i] = array[j];
                    array[j] = buffer;
                }
            }
        }
        return  array;


    }
}
