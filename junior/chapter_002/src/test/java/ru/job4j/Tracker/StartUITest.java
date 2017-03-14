package ru.job4j.Tracker;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Katy on 01.03.2017.
 */
public class StartUITest {

    @Test
    public void getAllTest() {

        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");


        Item[] items = {item1, item2};
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);

        Item[] result = tracker.getAll();
        assertThat(result, is(items));
    }




        /**
         * Тест добавления и показа всех заявок.
         */
        @Test
        public void addTaskTest() {
            Tracker tracker = new Tracker();
            Input input = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "y"});

            new StartUI(input,tracker).init();
        }

         /**
         * Тест редактирования заявки
         */
         @Test
         public void editTest() {
             Item item1 = new Item("task1", "description1");
             Tracker tracker = new Tracker();
             tracker.add(item1);

             Input input = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "2",tracker.add(item1).getId(), "new name", "new desc", "n", "1", "y"});

             new StartUI(input,tracker).init();
         }

        /**
         * Добавление комментария
         */
        @Test
        public void addCommentTest() {

            Tracker tracker = new Tracker();
            Item item1 = new Item("task1", "description1");
//
            Input inputComm = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "5", tracker.add(item1).getId(), "new comment", "n", "1", "y"});

            new StartUI(inputComm ,tracker).init();
        }

        /**
         * Поиск по id
         */
        @Test
        public void findByIDTest() {


            Tracker tracker = new Tracker();
            Item item1 = new Item("task1", "description1");
//
            Input inputId = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "3", tracker.add(item1).getId(), "y"});

            new StartUI(inputId,tracker).init();
        }

        /**
         * Поиск слов в заявке
         */
        @Test
        public void findByWordTest() {
            Tracker tracker = new Tracker();

            Input inputWord = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "6", "old", "y"});

            new StartUI(inputWord,tracker).init();
        }

        /**
         *  Удаление заявки
         */
        @Test
        public void deleteTaskTest() {


            Tracker tracker = new Tracker();
            Item item1 = new Item("task1", "description1");

            Input inputDelete = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "4", tracker.add(item1).getId(), "n", "1", "y"});

            new StartUI(inputDelete,tracker).init();
        }

}