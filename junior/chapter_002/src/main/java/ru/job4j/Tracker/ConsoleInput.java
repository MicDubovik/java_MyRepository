package ru.job4j.Tracker;

import java.util.Scanner;

/**
 * Created by Katy on 01.03.2017.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }




    @Override
    public int ask(String question, int[] number) throws MenuOutExeption {

        int key = Integer.valueOf(this.ask(question));

        boolean exist = false;
        for(int value : number) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutExeption(" Out of menu range. ");
        }
    }

}