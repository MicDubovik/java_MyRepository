package ru.job4j.profession;

/**
 * Created by Katy on 27.02.2017.
 */
public class Doctor extends Profession {

    private String speciality;


    public Doctor() {
    }

    public Doctor(String speciality) {
        this.speciality = speciality;
    }

    public Doctor(String qualification, String name, int old, String speciality) {
        super(qualification, name, old);
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public  void cure(){
        System.out.println("Лечу больного");

    }



}
