package ru.job4j.Test;

public class Array {


    public static void main(String[] args) {

        int[][] array = new int[3][5];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = k++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
