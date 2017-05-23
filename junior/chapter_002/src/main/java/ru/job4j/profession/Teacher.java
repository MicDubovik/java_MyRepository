package ru.job4j.profession;

/**
 * Teacher.
 */
public class Teacher extends Profession {
    /**
     * Education.
     */
    private String education;

    /**
     * Constructor.
     */
    public Teacher() {
    }

    /**
     * Constructor.
     * @param education
     */
    public Teacher(String education) {
        this.education = education;
    }

    /**
     * Constructor.
     * @param qualification
     * @param name
     * @param old
     * @param education
     */
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

    /**
     * Working.
     */
    public  void teach(){
        System.out.println("Идет урок");
    }

}
