package ru.job4j.Tracker;

/**
 * StartUI.
 */
public class StartUI {
    /**
     * Input.
     */
    private Input input;
    /**
     * number.
     */
    private int[] number;
    /**
     * Tracker.
     */
    Tracker tracker;
    /**
     * MenuTracker.
     */
    MenuTracker menu;

    /**
     * Constructor.
     *
     * @param input
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Constructor.
     *
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Init.
     */
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

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
        Item item = new Item();
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input, tracker).init();
    }
}


