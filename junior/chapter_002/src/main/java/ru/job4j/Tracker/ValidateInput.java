package ru.job4j.Tracker;

/**
 *
 */
public class ValidateInput extends ConsoleInput {




    public int ask(String question, int[] number) {
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
