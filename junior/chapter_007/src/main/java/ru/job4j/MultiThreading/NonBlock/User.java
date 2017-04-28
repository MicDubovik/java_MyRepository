package ru.job4j.MultiThreading.NonBlock;

public class User {

    private String name;
    private int version;

    public User(String name) {
        this.name = name;
        this.version = 0;
    }

    public String getName() {
        return name;
    }


    public int getVersion() {
        return version;
    }

    public void changeVersion() {
        this.version++;
    }
}
