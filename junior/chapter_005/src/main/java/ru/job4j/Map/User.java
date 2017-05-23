package ru.job4j.Map;

import java.util.*;

/**
 * User.
 */
public class User {
    /**
     * Name.
     */
    private String name;
    /**
     * children.
     */
    private int children;
    /**
     * Date.
     */
    private Calendar birthday;

    /**
     * Constructor.
     * @param name
     * @param children
     * @param birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Constructor.
     */
    public User() {
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
    public int getChildren() {
        return children;
    }

    /**
     * Set.
     * @param children
     */
    public void setChildren(int children) {
        this.children = children;
    }
    /**
     * Get.
     * @return
     */
    public Calendar getBirthday() {
        return birthday;
    }

    /**
     * Set.
     * @param birthday
     */
    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    /**
     * equals.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    /**
     * hashCode.
     * @return
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {

        Set<User> setlist = new HashSet<>();

        Map<User, User> userMap = new HashMap();

        Calendar c = new GregorianCalendar(1980, 10, 25);

        User user = new User("Mik", 2, c);
        User user1 = new User("Mik", 2, c);

        setlist.add(user);
        setlist.add(user1);

        System.out.println(setlist);

        userMap.put(user, user);
        userMap.put(user1, user1);

        System.out.println(userMap);

    }
}
