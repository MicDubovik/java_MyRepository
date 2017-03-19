package ru.job4j.CollectionFramework;

import java.util.ArrayList;
import java.util.List;

/**
 * Application for convert array to ArrayList and backward .
 */

public class ConvertList {
    /**
     * Method for convert array to ArrayList.
     *
     * @param array
     * @return
     */

    public List<Integer> toList(int[][] array) {
        List<Integer> integerList = new ArrayList<>();
        Integer[] integer = new Integer[array.length * array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                integerList.add(array[i][j]);
            }
        }


        return integerList;
    }

    /**
     * Method for convert ArrayList to array.
     *
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array ;
        int size2 = 0;

        if (list.size() % rows == 0) {
            size2 = list.size() / rows;
            array = new int[rows][size2];
        } else {
            size2 = list.size() / rows + 1;
            array = new int[rows][size2];
        }

        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < size2; j++) {
                if (k >= list.size()) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(k);
                    k++;
                }
            }

        }
        return array;
    }

    /**
     * Method for conver all array to ArrayList.
     * @param list
     * @return
     */

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (int[] ints : list) {
            for (int anInt : ints) {
                result.add(anInt);

            }
        }
        return result;
    }

    /**
     * Start application.
     *
     * @param args
     */
    public static void main(String[] args) {

        int[][] array = new int[][]{
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}};

        ConvertList list = new ConvertList();

        /**
         * Converting array to ArrayList.
         */
        list.toList(array);
        for (Integer integer : list.toList(array)) {
            System.out.println(integer+" ");
        }
        System.out.println();

        /**
         * Print to screen array.
         */
        int tab2 = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
                tab2++;
                if (tab2 == array[0].length) {
                    System.out.println();
                    tab2 = 0;
                }
            }
        }

        System.out.println();

/**
 * Print to screen new array from List.
 */
        int tab = 0;
        int rows = 6;
        for (int[] integers : list.toArray(list.toList(array), rows)) {
            for (int integer : integers) {

                System.out.print(integer + " ");
                tab++;
                if (tab == rows) {
                    System.out.println();
                    tab = 0;
                }
            }
        }

        System.out.println();

        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[]{1, 2});
        list2.add(new int[]{3, 4, 5, 6});

        System.out.println(list.convert(list2)+" ");
    }
}
