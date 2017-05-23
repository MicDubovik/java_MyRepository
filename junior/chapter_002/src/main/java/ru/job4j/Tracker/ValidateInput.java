package ru.job4j.Tracker;

/**
 *ValidateInput
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Ask.
     * @param question
     * @param number
     * @return
     */
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
