package ru.job4j.Tracker;

/**
 * Created by Katy on 27.02.2017.
 */
public class StartUI {
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Item item1 = new Item("first name", "first desc", "first comment");
        Item item2 = new Item("second name", "second desc", "second comment");
        Item item3 = new Item("third name", "third desc");

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

    }
}

