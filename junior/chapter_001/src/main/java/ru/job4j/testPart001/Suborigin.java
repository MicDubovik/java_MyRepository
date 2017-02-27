package ru.job4j.testPart001;

import java.util.Arrays;

/**
 * Тестовое задание 001
 * Сравнить и удостовериться ,что строка sub является подстрокой origin
 */
public class Suborigin {
    boolean result = false;

    int counter;

    /**
     * Вариант 1 , сравнение методом contains
     * @param origin
     * @param sub
     * @return
     */

    public boolean compareSubFromOrig(String origin, String sub) {

        if (origin.contains(sub)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Вариант 2 ,сравнение с помощью подстрок substring .
     * @param origin
     * @param sub
     * @return
     */

    public boolean comp2(String origin, String sub) {
        for (int i = 0; i < sub.length(); i++) {
            counter++;
        }

        for (int i = 0; i < origin.length() - counter + 1; i++) {

            if (origin.substring(i, i + counter).equals(sub)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Вариант 3 , сравнение после преобразования строк в массив символов.
     * @param origin
     * @param sub
     */

    public boolean comp3(String origin, String sub) {
        /**
         * создаем массивы из входных строк
         * создаем пустой массив длинной равной длинне подстроки
         * поочередно сравниваем символы в массивах и если они равны
         * - заполняем ими пустой массив.
         */

        char[] charsOr = origin.toCharArray();
        char[] charsSub = sub.toCharArray();
        char[] charnew = new char[sub.length()];
        int x=0;
        for (int i = 0; i < charsSub.length; i++) {
            for (int j = x; j < charsOr.length ; j++) {
                x++;
                if (charsOr[j] == charsSub[i]) {
                    charnew[i] = charsOr[j];
                    break;
                }
            }
        }
        /**
         * превращаем наши массивы в строки
         * и сравниваем их.
         */

        if (Arrays.equals(charnew,charsSub)) {
            result=true;
        }
        else {
            result=false;
        }
        return result;
    }
}


