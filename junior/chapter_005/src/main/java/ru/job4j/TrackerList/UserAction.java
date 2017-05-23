package ru.job4j.TrackerList;

/**
 * UserAction .
 */
public interface UserAction {
    /**
     * key.
     * @return
     */
    int key();

    /**
     * execute.
     * @param input
     * @param tracker
     */
    void execute(Input input,Tracker tracker);

    /**
     * info.
     * @return
     */
    String info();
}
