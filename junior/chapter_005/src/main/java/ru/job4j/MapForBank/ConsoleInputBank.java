package ru.job4j.MapForBank;

import java.util.HashMap;
import java.util.Scanner;

public class ConsoleInputBank implements InputBank {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }




    @Override
    public int ask(String question, HashMap<Integer, UserActionBank> number) throws MenuOutExeption {

        int key = Integer.valueOf(this.ask(question));

        boolean exist = false;
        for(int value : number.keySet()) {
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
