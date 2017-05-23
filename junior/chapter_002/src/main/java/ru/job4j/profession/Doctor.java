package ru.job4j.profession;

/**
 * Class Doctor.
 */
public class Doctor extends Profession {
    /**
     * Speciality.
     */
    private String speciality;

    /**
     * Constructor
     */
    public Doctor() {
    }
    /**
     * Constructor
     */
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

    /**
     * Working.
     */
    public  void cure(){
        System.out.println("Лечу больного");

    }



}
