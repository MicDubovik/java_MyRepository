package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList;

import java.util.HashMap;

/**
 * Created by Katy on 27.02.2017.
 */
public class StartUI {
    private Input input;
    private HashMap<Integer, UserAction> number;
    Tracker tracker;
    MenuTracker menu;

    public StartUI(Input input) {
        this.input = input;
    }

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        menu = new MenuTracker(input, tracker);
        number = menu.fillActions();

        String exit = null;

        System.out.println("*********************");
        System.out.println("*  Пограмма заявок  *");
        System.out.println("*********************");

        do {
            menu.show();
            menu.select(input.ask("select: ", number));

            exit = this.input.ask("Exit ?(y/n):");
            if (exit.equals("y")) {
                tracker.initDB.getDb().closeConnect();
                System.out.println("Connection closed");
            }
        } while (!"y".equals(exit));
    }


    public static void main(String[] args) {
        Item item = new Item();
        Tracker tracker = new Tracker();

        tracker.initDB.createConnection();
        Input input = new ValidateInput();
        new StartUI(input, tracker).init();
    }
}


