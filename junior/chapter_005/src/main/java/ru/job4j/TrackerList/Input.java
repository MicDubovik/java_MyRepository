package ru.job4j.TrackerList;

import java.util.HashMap;

/**
 * Created by Katy on 01.03.2017.
 */
public interface Input {

    String ask(String question) ;

    int ask(String question,HashMap<Integer, UserAction> number) ;
}
