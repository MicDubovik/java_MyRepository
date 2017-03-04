package ru.job4j.Tracker;

/**
 * Created by Katy on 02.03.2017.
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

    public int[] getActions() {
        int[] result = new int[number];
        for (int index = 0; index < result.length; index++) {
            result[index] = actions[index].key();
        }
        return result;
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
        System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
    }

    private class AddItem extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 0;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please enter the item name: ");
            String description = input.ask("Please enter the item description: ");
            tracker.add(new Item(name, description));
            /**
             * тестовая заявка
             */
            tracker.add(new Item("1111", "test task1", "test description1", "test comment"));

        }
        /**
         * Информация о методе.
         */
        AddItem() {
            super("Add the new item.");
        }
    }

    private class EditItem extends BaseAction {
        /**
         * Номер метода.
         * @return number.
         */
        public int key() {
            return 1;
        }
        /**
         * Действие метода.
         * @param input input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            select(3);
            Item item3 = new Item();
            String id = input.ask("Please enter the tasks ID:");
            String name = input.ask("Please enter the tasks name: ");
            String description = input.ask("Please enter the tasks description: ");
            item3 = tracker.findById(id);
            tracker.editItem(item3, new Item(name, description));
        }
        /**
         * Информация о методе.
         */
        EditItem() {
            super("Edit item.");
        }
    }



    private class ShowAllItems extends BaseAction {



        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null)
                 showTasks(item);

            }
        }

        /**
         * Конструктор принимающий имя метода.
         *
         *
         */
       public ShowAllItems () {
            super("Show all tasks.");
        }

    }

    private class FindItemById extends BaseAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            try {

                String id = input.ask("Please enter the id item: ");
                Item result = tracker.findById(id);
                showTasks(result);
            } catch (NullPointerException npe) {
                System.out.println("Please enter valid id");
            }
        }
            FindItemById( ) {

                super("Find item by id.");
            }
        }


    private class FindItemByComment extends BaseAction {

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

        public FindItemByComment() {
            super("Find item by comment.");
        }
    }

    private class DeleteItem extends BaseAction {

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
        DeleteItem() {
            super("Delete item.");
        }

    }



    private class AddComment extends BaseAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
          try {
              String id = input.ask("Please enter the tasks ID:");
             Item item = tracker.findById(id);
              String comment = input.ask("Please enter comment for the tasks : ");
              tracker.addComment(item, comment);
          }catch (NullPointerException npe) {
              System.out.println("Please enter valid id");
          }
        }

        public AddComment( ) {
            super("Add comment");
        }
    }
}
