package ru.job4j.Tracker;

/**
 * Created by Katy on 27.02.2017.
 */
public class StartUI {
    private Input input;
    String operation;

    public StartUI(Input input) {
        this.input = input;
    }


    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        int[] number = new int[menu.getActions().length];
        for (int index = 0; index < menu.getActions().length; index++) {
            number[index] = index + 1;
        }

        menu.fillActions();
        System.out.println("*********************");
        System.out.println("*  Пограмма заявок  *");
        System.out.println("*********************");

        do {
            menu.show();
            menu.select(input.selectNumber("select: ", number));
        } while (!"y".equals(this.input.operation("Exit ?(y/n):")));
    }


    public static void main(String[] args) {
        Item item = new Item();
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}


