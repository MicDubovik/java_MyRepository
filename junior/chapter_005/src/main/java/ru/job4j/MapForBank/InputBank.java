package ru.job4j.MapForBank;

import java.util.HashMap;

/**
 * InputBank.
 */
public interface InputBank {

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
    int ask(String question,HashMap<Integer, UserActionBank> number) ;
}
