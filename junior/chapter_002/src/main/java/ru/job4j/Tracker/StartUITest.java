package ru.job4j.Tracker;

/**
 * Created by Katy on 01.03.2017.
 */
public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[]{"name task"});
        Tracker tracker = new Tracker();

        Item item1 = new Item("first name", "first desc", "first comment");
        Item item2 = new Item("second name", "second desc", "second comment");
        Item item3 = new Item("third name", "third desc");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);

        String name = ("name: ");
        String description = (" description: ");
        String id = (" ID");
        tracker.add(new Item(name, description));


     //   String id = (" ID");


        new StartUI(input).init();
    }
}
