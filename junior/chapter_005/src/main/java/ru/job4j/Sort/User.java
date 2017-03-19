package ru.job4j.Sort;

public class User  implements Comparable<User> {

    private String name;
    private int age ;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

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
