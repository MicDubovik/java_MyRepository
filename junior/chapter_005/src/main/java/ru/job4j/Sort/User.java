package ru.job4j.Sort;

/**
 * User.
 */
public class User  implements Comparable<User> {
    /**
     * Name.
     */
    private String name;
    /**
     * Age.
     */
    private int age ;

    /**
     * User.
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get.
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Set.
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method compare params age.
     * @param o
     * @return
     */
    @Override
    public int compareTo(User o) {
        return   String.valueOf(age).compareTo(String.valueOf(o.getAge()));
    }
}
