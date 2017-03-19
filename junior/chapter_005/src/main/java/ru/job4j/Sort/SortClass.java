package ru.job4j.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Point for start.
 */
public class SortClass {

    /**
     * Method for change List to TreeSet.
     * @param users
     * @return
     */
    public Set<User> sort(List<User> users) {

        Set<User> userSet = new TreeSet<>();

        for (User user : users) {
            userSet.add(user);
        }
        return userSet;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("Mik", 25));
        users.add(new User("Andrey", 35));
        users.add(new User("Zero", 15));
        users.add(new User("Nikita", 30));


        SortClass sortClass = new SortClass();



        for (User user : sortClass.sort(users)) {
            System.out.println(user.getName() + " " + user.getAge());
        }
    }
}
