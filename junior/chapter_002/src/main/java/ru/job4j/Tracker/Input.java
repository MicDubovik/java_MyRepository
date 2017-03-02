package ru.job4j.Tracker;

/**
 * Created by Katy on 01.03.2017.
 */
public interface Input {

    String askName(String question);
    String askDesc(String question);
    String askComment(String question);
    String askId(String question);
    String askWord(String s);
    String operation(String operation);
    int selectNumber(String question,int[] number);
}
