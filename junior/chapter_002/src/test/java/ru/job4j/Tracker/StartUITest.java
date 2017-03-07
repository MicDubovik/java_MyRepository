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
            Input input = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "y"});

            new StartUI(input).init();
        }

         /**
         * Тест редактирования заявки
         */
         @Test
         public void editTest() {
             Tracker tracker = new Tracker();
             tracker.add(new Item("1111","test name","test desc","test comm"));
             Input inputEdit = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "2","1111", "new name", "new desc", "n", "1", "y"});

             new StartUI(inputEdit).init();
         }

        /**
         * Добавление комментария
         */
        @Test
        public void addCommentTest() {
            Input inputComm = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "5", "1111", "new comment", "n", "1", "y"});

            new StartUI(inputComm).init();
        }

        /**
         * Поиск по id
         */
        @Test
        public void findByIDTest() {
            Input inputId = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "3", "1111", "y"});

            new StartUI(inputId).init();
        }

        /**
         * Поиск слов в заявке
         */
        @Test
        public void findByWordTest() {
            Input inputWord = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "6", "test", "y"});

            new StartUI(inputWord).init();
        }

        /**
         *  Удаление заявки
         */
        @Test
        public void deleteTaskTest() {
            Input inputDelete = new StubInput(new String[]{"0", "old task", "old newdesc", "n", "1", "n", "4", "1111", "n", "1", "y"});

            new StartUI(inputDelete).init();
        }

}