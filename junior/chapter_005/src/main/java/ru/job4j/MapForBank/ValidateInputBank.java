package ru.job4j.MapForBank;

import java.util.HashMap;

class ValidateInput extends ConsoleInputBank {

    public int ask(String question, HashMap<Integer, UserActionBank> number) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, number);
                invalid = false;

            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value ;
    }
}
