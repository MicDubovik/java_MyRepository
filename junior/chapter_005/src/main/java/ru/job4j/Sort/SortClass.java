package ru.job4j.Sort;

import java.util.*;

/**
 * Point for start.
 */
public class SortClass {


    /**
     * Method for change List to TreeSet.
     *
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

    /**
     * Method sort by HashCode.
     * @param users
     * @return
     */

    public List<User> sortHash(List<User> users) {


        Comparator<User> compUserHash = new SortByHashCode();

         Collections.sort(users,compUserHash);
         return users;
    }

    /**
     * Method sort by length.
     * @param users
     * @return
     */
    public List<User> sortLength(List<User> users) {
        Comparator<User> compUserLength = new SortByLongNameComparator();

        Collections.sort(users,compUserLength);


         return users;


    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("Mik", 25));
        users.add(new User("Andrey", 35));
        users.add(new User("Zero", 15));
        users.add(new User("Vova", 30));
        users.add(new User("Vovakonby", 30));

        SortClass sortClass = new SortClass();

        for (User user : sortClass.sort(users)) {
            System.out.println(user.getName() + " " + user.getAge());
        }
        System.out.println();

        for (User user : sortClass.sortHash(users)) {
            System.out.println(user.getName() + " " + user.getAge() + "  " + user.hashCode());
        }

        System.out.println();

        for (User user : sortClass.sortLength(users)) {
            System.out.println(user.getName() + " " + user.getAge()+"  "+ user.hashCode());
        }
    }

}
