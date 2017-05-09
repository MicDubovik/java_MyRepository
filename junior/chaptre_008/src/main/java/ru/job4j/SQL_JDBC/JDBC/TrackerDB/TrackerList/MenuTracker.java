package ru.job4j.SQL_JDBC.JDBC.TrackerDB.TrackerList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс обертка
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private HashMap<Integer, UserAction> possibleAction = new HashMap<>();
    /**
     * Init my connection.
     */



    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public HashMap<Integer, UserAction> fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new EditItem());
        this.actions.add(new FindItemById());
        this.actions.add(new DeleteItem());
        this.actions.add(new AddComment());
        this.actions.add(new FindItemByComment());
        this.actions.add(new CreateTable());
        this.actions.add(new SelectTable());



        for (int i = 0; i < actions.size(); i++) {
            this.possibleAction.put(actions.get(i).key(), actions.get(i));
        }
        return possibleAction;
    }

    public void select(int key) {

        this.possibleAction.get(key).execute(this.input, this.tracker);

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
            tracker.initDB.addItem(name, description);

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


            String id = input.ask("Please enter  tasks ID:");
            String name = input.ask("Please enter new tasks name: ");
            String description = input.ask("Please enter tasks description: ");

            tracker.initDB.update(id,name,description);
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

            tracker.initDB.showAllItem();
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

            tracker.initDB.findItemById(id);

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

            tracker.initDB.finfItemByText(word);
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
                String id = input.ask("Please, enter task's ID: ");

                tracker.initDB.deleteItemById(id);
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

                String comment = input.ask("Please enter comment for the tasks : ");


                tracker.initDB.insertComment(id,comment);

            } catch (NullPointerException npe) {
                System.out.println("Please enter valid id");
            }

        }
    }
    private class CreateTable extends BaseAction {

        /**
         * Информация о методе.
         */
        CreateTable() {
            super("Create table for item.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 7;
        }

        /**
         * Действие метода.
         *
         * @param input   input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String tableName = input.ask("Please enter table name: ");
            String id = input.ask("Please enter name for column id: ");
            String name = input.ask("Please enter name for column name: ");
            String desc = input.ask("Please enter name for column description: ");
            String comment = input.ask("Please enter name for column comment: ");

            tracker.initDB.setTablename(tableName);

            tracker.initDB.getStructure().setId(id);
            tracker.initDB.getStructure().setName(name);
            tracker.initDB.getStructure().setDescription(desc);
            tracker.initDB.getStructure().setComment(comment);



             tracker.initDB.createTable(tableName);

            tracker.initDB.columnInit();

        }

    }

    private class SelectTable extends BaseAction {

        /**
         * Информация о методе.
         */
        SelectTable() {
            super("Select table for item.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 8;
        }

        /**
         * Действие метода.
         *
         * @param input   input.
         * @param tracker tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String tableName = input.ask("Please select your table name: ");

            tracker.initDB.setTablename(tableName);

            tracker.initDB.columnInit();

        }

    }
}
