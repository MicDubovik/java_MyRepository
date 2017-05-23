package ru.job4j.ListToMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convert List to Map.
 */
public class UserConvert {
    /**
     * process.
     *
     * @param list
     * @return HashMap<Integer, User>.
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> mymap = new HashMap<>();

        for (User user : list) {
            mymap.put(user.getId(), user);
        }
        return mymap;
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1111, "Paul", "Berlin"));
        users.add(new User(222, "Adam", "Bristol"));
        users.add(new User(3333, "Mik", "Minsk"));

        UserConvert convert = new UserConvert();
        HashMap<Integer, User> map = convert.process(users);

        for (Integer integer : map.keySet()) {
            System.out.println("All key " + integer);
        }
        for (User user : map.values()) {
            System.out.println();
        }
        map.entrySet();
        for (Map.Entry<Integer, User> integerUserEntry : map.entrySet()) {
            System.out.println("Key-" + integerUserEntry.getKey() + "\t" + "Value-" + integerUserEntry.getValue().getName() +
                    "  " + integerUserEntry.getValue().getCity());
        }
    }
}
