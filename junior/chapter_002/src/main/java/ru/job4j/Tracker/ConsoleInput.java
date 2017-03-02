package ru.job4j.Tracker;

import java.util.Scanner;

/**
 * Created by Katy on 01.03.2017.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askName(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public String askDesc(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public String askComment(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public String askId(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public String askWord(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public String operation(String operation) {
        System.out.println(operation);
        return scanner.nextLine();
    }

    @Override
    public int selectNumber(String question, int[] number) {

        int key = Integer.valueOf(this.operation(question));

            return key;

    }
}
