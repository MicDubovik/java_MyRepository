package ru.job4j.TrackerList;

import java.util.HashMap;

/**
 * Input.
 */
public interface Input {
    /**
     * Ask.
     * @param question
     * @return
     */
    String ask(String question) ;

    /**
     * Ask.
     * @param question
     * @param number
     * @return
     */
    int ask(String question,HashMap<Integer, UserAction> number) ;
}
