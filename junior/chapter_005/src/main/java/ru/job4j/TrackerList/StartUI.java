package ru.job4j.TrackerList;

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

        System.out.println("*********************");
        System.out.println("*  Пограмма заявок  *");
        System.out.println("*********************");

        do {
            menu.show();
            menu.select(input.ask("select: ", number));
        } while (!"y".equals(this.input.ask("Exit ?(y/n):")));
    }


    public static void main(String[] args) {
       Item item = new Item();
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input,tracker).init();
    }
}

