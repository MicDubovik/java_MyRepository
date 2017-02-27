package ru.job4j.profession;

/**
 * Created by Katy on 27.02.2017.
 */
public class Engineer extends Profession {

    private String profession;

    public Engineer() {
    }

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

    public  void produce(){
        System.out.println("Готовый продукт");

    }

}
