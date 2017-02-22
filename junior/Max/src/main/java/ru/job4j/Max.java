package ru.job4j;

/**
 * Найти максимальное из 2-х чисел
 */

public class Max {


    int result;
    int result2;

    /**
     * Определение максимального из чисел
     * Если числа равны возвращаем 0
     *
     * @param value1 входящие аргументы
     * @param value2 входящие аргументы
     * @return возвращаемое значение
     */


    public int max(int value1, int value2) {
        if (value1 > value2) {
            this.result = value1;
        } else if (value1 < value2) {
            this.result = value2;
        } else {
            this.result = value1;   // присваиваем любое значение из 2-х
        }
        return result;
    }

    /**
     * Используем перегрузку метода max с двумя аргументами
     * @param first
     * @param second
     * @param third
     * @return
     */

    public int max(int first, int second, int third) {

        int res1 = max(first, second);
        int res2 = max(second, third);
        int res3 = max(res1,res2);
        return res3 ;

    }


}
