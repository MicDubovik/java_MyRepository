package ru.job4j.Test;

/**
 * Created by Katy on 02.03.2017.
 */
public class Main {
    String word = "bu";
    String string;

    String[] array = new String[3];


    public String findByComment(String word) {
        String result = null;

        for (int i = 0; i < array.length; i++) {
            if ( array[i].contains(word) ) {
                result = array[i];
                break;
            }
        }
        return result ;

    }


    public static void main(String[] args) {

         Main  main = new Main();
         main.array[0]="bull";
         main.array[1]="bull";
         main.array[2]="bull";


        System.out.println(main.findByComment("ul"));


    }
}
