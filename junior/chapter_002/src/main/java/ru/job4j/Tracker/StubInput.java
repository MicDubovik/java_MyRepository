package ru.job4j.Tracker;

/**
 * Created by Katy on 01.03.2017.
 */
public class StubInput implements Input {
    private String[] answers;
    private int position =0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }



    @Override
    public int ask(String question, int[] number) throws MenuOutExeption {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : number) {
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
