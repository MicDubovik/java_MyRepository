package ru.job4j.MapForBank;

import java.util.HashMap;

public interface InputBank {


    String ask(String question) ;

    int ask(String question,HashMap<Integer, UserActionBank> number) ;
}
