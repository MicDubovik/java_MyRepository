package ru.job4j.profession;

/**
 * Created by Katy on 27.02.2017.
 */
public class Teacher extends Profession {

    private String education;

    public Teacher() {
    }

    public Teacher(String education) {
        this.education = education;
    }

    public Teacher(String qualification, String name, int old, String education) {
        super(qualification, name, old);
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public  void teach(){
        System.out.println("Идет урок");
    }

}
