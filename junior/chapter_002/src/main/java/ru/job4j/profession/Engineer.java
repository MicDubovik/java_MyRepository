package ru.job4j.profession;

/**
 * Engineer.
 */
public class Engineer extends Profession {
    /**
     * Profession.
     */
    private String profession;

    /**
     * Constructor.
     */
    public Engineer() {
    }
    /**
     * Constructor.
     */
    public Engineer(String profession) {
        this.profession = profession;
    }

    public Engineer(String qualification, String name, int old, String profession) {
        super(qualification, name, old);
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * Working.
     */
    public  void produce(){
        System.out.println("Готовый продукт");

    }

}
