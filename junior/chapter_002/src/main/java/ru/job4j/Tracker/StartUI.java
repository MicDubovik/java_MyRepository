package ru.job4j.Tracker;

/**
 * Created by Katy on 27.02.2017.
 */
public class StartUI {
    private Input input;
    String operation;
    private int[] number;
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
        tracker = new Tracker();
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
        Input input = new ValidateInput();
        new StartUI(input).init();
    }
}


