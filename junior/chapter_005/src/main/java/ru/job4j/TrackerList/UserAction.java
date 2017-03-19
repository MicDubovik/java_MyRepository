package ru.job4j.TrackerList;

/**
 * Created by Katy on 02.03.2017.
 */
public interface UserAction {
    int key();
    void execute(Input input,Tracker tracker);
    String info();
}
