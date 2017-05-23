package ru.job4j.MultiThreading.NonBlock;

/**
 * User.
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     *  version.
     */
    private int version;

    /**
     * Constructor.
     * @param name
     */
    public User(String name) {
        this.name = name;
        this.version = 0;
    }

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get
     * @return
     */
    public int getVersion() {
        return version;
    }

    /**
     * changeVersion.
     */
    public void changeVersion() {
        this.version++;
    }
}
