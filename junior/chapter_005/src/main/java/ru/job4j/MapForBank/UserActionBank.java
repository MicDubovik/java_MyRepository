package ru.job4j.MapForBank;

public interface UserActionBank {

    int key();
    void execute(InputBank input,Bank bank);
    String info();
}
