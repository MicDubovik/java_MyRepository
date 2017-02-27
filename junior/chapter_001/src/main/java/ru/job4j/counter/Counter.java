package ru.job4j;

/**
 * Нахождение суммы четных чисел в заданном диапазоне
 */
public class Counter {



    /**
     *  Метод нахождения суммы четных чисел
     * @param start начальное число
     * @param finish конечное число
     * @return
     */

    public int add(int start, int finish) {
        int sum=0;
        for (int i = start; i <=finish ; i++) {

            if (i%2==0){
                sum+=i;
            }

        }
        return sum;
    }
}
