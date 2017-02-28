package ru.job4j.Test;

/**
 * Created by Katy on 27.02.2017.
 */
public class Main {

    public static void main(String[] args) {

         String[] num = new String[5];

        for (int i = 0; i < num.length; i++) {
            num[i]="ok";
        }
        for (String i : num) {
            System.out.println(i);
        }
        num[2]=null;
        for (String i : num) {
            System.out.println(i);
        }



    }
}
