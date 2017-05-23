package ru.job4j.TrackerList;

import java.util.HashMap;

/**
 * ValidateInput
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Ask.
     * @param question
     * @param number
     * @return
     */
    public int ask(String question, HashMap<Integer, UserAction> number) {
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
