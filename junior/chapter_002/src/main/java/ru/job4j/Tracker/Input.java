package ru.job4j.Tracker;

/**
 * Input.
 */
public interface Input {
    /**
     * String ask.
     * @param question
     * @return
     */
    String ask(String question) ;

    /**
     * Method ask().
     * @param question
     * @param number
     * @return
     */
    int ask(String question,int[] number) ;
}
