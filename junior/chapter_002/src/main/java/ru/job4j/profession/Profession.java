package ru.job4j.profession;

/**
 * Profession.
 */
public class Profession {
    /**
     * Qualification.
     */
    protected String qualification ;
    /**
     * Name
     */
    protected String name;
    /**
     * Age.
     */
    protected int old;

    /**
     * Constructor.
     */
    public Profession() {
    }

    /**
     * Constructor.
     * @param qualification
     * @param name
     * @param old
     */
    public Profession(String qualification, String name, int old) {
        this.qualification = qualification;
        this.name = name;
        this.old = old;
    }

}
