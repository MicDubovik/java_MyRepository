package ru.job4j;

/**
 * Найти максимальное из 2-х чисел
 */

public class Max {


    int result ;

    /**
     * Определение максимального из чисел
     * Если числа равны возвращаем 0
     * @param value1 входящие аргументы
     * @param value2 входящие аргументы
     * @return       возвращаемое значение
     */


    public int max(int value1, int value2){
        if (  value1> value2){
             this.result = value1 ;
        }
        else if ( value1< value2){
            this.result = value2;
        }
        else {
            this.result = 0;
        }
        return result;
    }


}
