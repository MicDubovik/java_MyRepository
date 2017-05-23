package ru.job4j.TrackerList;

import java.util.HashMap;

/**
 * StubInput.
 */
public class StubInput implements Input {
    /**
     * answers.
     */
    private String[] answers;
    /**
     * position.
     */
    private int position =0;

    /**
     * Constructor.
     * @param answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Ask.
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Ask.
     * @param question
     * @param number
     * @return
     * @throws MenuOutExeption
     */
    @Override
    public int ask(String question, HashMap<Integer, UserAction> number) throws MenuOutExeption {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (Integer value : number.keySet()) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutExeption("Out if menu exception");
        }
    }
}
