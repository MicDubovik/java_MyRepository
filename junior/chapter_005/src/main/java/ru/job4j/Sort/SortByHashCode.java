package ru.job4j.Sort;

import java.util.Comparator;

public class SortByHashCode implements Comparator<User> {

    /**
     * Override method compare for sort by hashCode.
     * @param user1
     * @param user2
     * @return
     */
    @Override
    public int compare(User user1, User user2) {
        if (user1.hashCode()> user2.hashCode())
            return 1;
        else if (user1.hashCode()< user2.hashCode())
            return -1;
        else
        return  0;
    }
}
