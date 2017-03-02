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
    public String askName(String question) {
        return answers[position++];
    }

    @Override
    public String askDesc(String question) {

        return answers[position++];
    }

    @Override
    public String askComment(String question) {

        return answers[position++];
    }

    @Override
    public String askId(String question) {

        return answers[position++];
    }

    @Override
    public String askWord(String s) {
        return answers[position++];
    }

    @Override
    public String operation(String operation) {
        return answers[position++];
    }
}
