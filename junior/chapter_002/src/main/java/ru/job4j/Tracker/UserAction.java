package ru.job4j.Tracker;

/**
 * Created by Katy on 02.03.2017.
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
