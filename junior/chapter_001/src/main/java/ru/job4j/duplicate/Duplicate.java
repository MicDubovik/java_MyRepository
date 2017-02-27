package ru.job4j.duplicate;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Задача : удалить дублирующиеся строки
 */
public class Duplicate {

    /**
     * Метод удаления дубликатов
     * @param strings
     * @return
     */

    public String[] removeDuplicate(String[] strings) {
        int counter = 0;
        /**
         * Присваиваем дубликатам значение любое значение ,для их идент-ии ,
         * к примеру "del" .
         */

        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])&&!strings[i].equals("del")) {
                    counter++;
                    strings[j] = "del";
                }
            }
        }
        /**
         * Смещаем дубликаты в конец массива и считаем
         * кол-во элементов без дубликатов
         */
        String buf = strings[0];
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals("del")) {
                    buf = strings[i];
                    strings[i] = strings[j];
                    strings[j] = buf;
                }
            }
        }
        /**
         * Создаем новый массив,с найденым кол-вом эл-в и копируем туда старый массив ,
         * обрезая его до дубликатов.
         */
        String[] newArray = copyOf(strings,counter);
        return newArray;

    }


}


//        String[] str = new String[counter];
//        int j = 0;
//        {
//
//            for (int i = 0; i < strings.length; i++) {
//
//                if (!strings[i].equals("del")) {
//                    str[j] = strings[i];
//                    j++;
//                }
//            }






