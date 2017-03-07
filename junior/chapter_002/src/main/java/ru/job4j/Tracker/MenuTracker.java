package ru.job4j.Tracker;

/**
 * Класс обертка
 */
public class MenuTracker {
    private int number = 0;
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int[] fillActions() {
        this.actions[number++] = new AddItem();
        this.actions[number++] = new ShowAllItems();
        this.actions[number++] = new EditItem();
        this.actions[number++] = new FindItemById();
        this.actions[number++] = new DeleteItem();
        this.actions[number++] = new AddComment();
        this.actions[number++] = new FindItemByComment();
        int[] possibleAction = new int[actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            possibleAction[i] = this.actions[i].key();
        }
        return possibleAction;

    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private void showTasks(Item item) {
        System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription() + " " + item.getComment());
    }

    private class AddItem extends BaseAction {

        /**
         * Информация о методе.
         */
        AddItem() {
            super("Add the new item.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 0;
        }

        /**
         * Действие метода.
         *
         * @param input   input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the item name: ");
            String description = input.ask("Please enter the item description: ");
            tracker.add(new Item(name, description));

        }

    }

    private class EditItem extends BaseAction {

        /**
         * Информация о методе.
         */
        EditItem() {
            super("Edit item.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 2;
        }

        /**
         * Действие метода.
         *
         * @param input   input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {


            String id = input.ask("Please enter the tasks ID:");
            String name = input.ask("Please enter the tasks name: ");
            String description = input.ask("Please enter the tasks description: ");
            Item item = tracker.findById(id);
            tracker.editItem(item, new Item(name, description));
        }

    }


    private class ShowAllItems extends BaseAction {

        /**
         * Конструктор принимающий имя метода.
         */
        public ShowAllItems() {
            super("Show all tasks.");
        }


        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null)
                    showTasks(item);

            }
        }

    }

    private class FindItemById extends BaseAction {

        FindItemById() {

            super("Find item by id.");
        }

        public int key() {
            return 3;
        }


        public void execute(Input input, Tracker tracker) {

            Item result = new Item();
            String id = input.ask("Please enter the id item: ");

            for (int i = 0; i < tracker.getAll().length; i++) {

                if (id.equals(tracker.getAll()[i].getId())) {
                    result = tracker.findById(id);
                    break;
                } else {
                    throw new NullPointerException("NullPointerException !!!");
                }
            }
            showTasks(result);
        }

    }


    private class FindItemByComment extends BaseAction {

        public FindItemByComment() {
            super("Find item by comment.");
        }

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String word = input.ask("Please enter word for search : ");

            Item item = tracker.findByComment(word);
            System.out.println(String.format("%s  ,%s  ,%s  ,%s", item.getId(), item.getName(), item.getDescription(), item.getComment()));

        }


    }

    private class DeleteItem extends BaseAction {

        DeleteItem() {
            super("Delete item.");
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            try {
                tracker.deleteItem(input.ask("Please, enter task's ID: "));
            } catch (NullPointerException npe) {
                System.out.println("Please enter valid id");
            }
        }

    }


    private class AddComment extends BaseAction {

        public AddComment() {
            super("Add comment");
        }

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            try {
                String id = input.ask("Please enter the tasks ID:");
                Item item = tracker.findById(id);
                String comment = input.ask("Please enter comment for the tasks : ");
                tracker.addComment(item, comment);
            } catch (NullPointerException npe) {
                System.out.println("Please enter valid id");
            }
        }
    }
}
