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


    public void fillActions() {
        this.actions[number++] = new AddItem();
        this.actions[number++] = new ShowItems();
        this.actions[number++] = new EditItem();
        this.actions[number++] = new FindItemById();
        this.actions[number++] = new DeleteItem();
        this.actions[number++] = new AddComment();
        this.actions[number++] = new FindItemByComment();

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

    private class AddItem implements UserAction {


        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.askName("Please enter the tasks name: ");
            String description = input.askDesc("Please enter the tasks description: ");

            /**
             * тестовая заявка
             */
            tracker.add(new Item("1111", "test task1", "test description1", "test comment"));
            tracker.add(new Item(name, description));
        }

        public String info() {
            return String.format("%s- %s", this.key(), "Add the new task.");
        }
    }

    private class EditItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            Item item3 = new Item();
            String id = input.askId("Please enter the tasks ID:");
            String name = input.askName("Please enter the tasks name: ");
            String description = input.askDesc("Please enter the tasks description: ");
            item3 = tracker.findById(id);
            tracker.editItem(item3, new Item(name, description));


        }

        public String info() {
            return String.format("%s- %s", this.key(), "Edit  task .");
        }
    }

    private class ShowItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                if (item != null)
                System.out.println(String.format("%s. %s. %s. %s", item.getId(), item.getName(), item.getDescription(), item.getComment()));

            }
        }

        public String info() {
            return String.format("%s- %s", this.key(), "Show all task.");

        }

    }

    private class FindItemById implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {

            String id = input.askId("Please enter the tasks ID:");
           Item item = tracker.findById(id);
            System.out.println(String.format("%s  ,%s  ,%s  ,%s", item.getId(), item.getName(), item.getDescription(), item.getComment()));

        }

        public String info() {
            return String.format("%s- %s", this.key(), "Find task by ID.");
        }
    }

    private class FindItemByComment implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String word = input.askWord("Please enter word for search : ");
            Item item = tracker.findByComment(word);
            System.out.println(String.format("%s  ,%s  ,%s  ,%s",item.getId(),item.getName(),item.getDescription(),item.getComment()));


        }

        @Override
        public String info() {
            return String.format("%s- %s", this.key(), "Find task by key-word.");
        }
    }

    private class DeleteItem implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            tracker.deleteItem(input.askId("Please, enter task's ID: "));
        }

        @Override
        public String info() {
            return String.format("%s- %s", this.key(), "Delete task.");
        }
    }


    private class AddComment implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
           String id = input.askId("Please enter the tasks ID:");
            String comment = input.askComment("Please enter comment for the tasks : ");
            tracker.addComment(tracker.findById(id), comment);
        }

        @Override
        public String info() {
            return String.format("%s- %s", this.key(), "Add comment for task.");
        }

    }
}
