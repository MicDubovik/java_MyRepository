package ru.job4j.factorial;

/**
 * Вычисление факториала числа
 */
public class Factorial {

    int number ;

    /**
     * Вычисление факториала рекурсивно .
     * @param number
     * @return
     */

    public int methodfactorial(int number){
        if (number==0)
            return 1;
        else return    number*methodfactorial(number-1);

    }

    /**
     * Нахождение факториала с помощью цикла
     * @param number
     * @return
     */
    public  int methodfactorial2(int number)
    {
        int result = 1;
        for (int i = 1; i <= number; ++i) {
            result *= i;
        }
        return result;
    }

}
