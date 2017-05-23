package ru.job4j.ListToMap;

/**
 * User.
 */
public class User {
    /**
     * Id.
     */
    private int id;
    /**
     * Name.
     */
    private String name;
    /**
     * City.
     */
    private String city;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param id
     * @param name
     * @param city
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Get.
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get.
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Set.
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Add.
     *
     * @param x
     */
    public void add(int x) {
        System.out.println();
    }

}
