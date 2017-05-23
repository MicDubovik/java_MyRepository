package ru.job4j.Sort;

import java.util.Comparator;

/**
 * SortByLongNameComparator.
 */
public class SortByLongNameComparator implements Comparator<User> {
    /**
     * Override method compare for sort by length .
     * @param user1
     * @param user2
     * @return
     */
    @Override
    public int compare(User user1, User user2) {

        if (user1.getName().length()>user2.getName().length())
        return  1;
        else if (user1.getName().length()<user2.getName().length())
            return -1;
        else return 0;
    }
}
