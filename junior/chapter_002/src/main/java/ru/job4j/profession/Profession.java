package ru.job4j.profession;

/**
 * Created by Katy on 27.02.2017.
 */
public class Profession {
    protected String qualification ;
    protected String name;
    protected int old;

    public Profession() {
    }

    public Profession(String qualification, String name, int old) {
        this.qualification = qualification;
        this.name = name;
        this.old = old;
    }

}
