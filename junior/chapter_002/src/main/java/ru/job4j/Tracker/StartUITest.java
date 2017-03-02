package ru.job4j.Tracker;

import org.testng.annotations.Test;

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


    public static void main(String[] args) {

        /**
         * Тест добавления и показа всех заявок.
         */
        Input input = new StubInput(new String[]{"1", "old task", "old newdesc", "4", "8"});

        new StartUI(input).init();

         /**
         * Тест редактирования заявки
         */
        Input inputEdit = new StubInput(new String[]{"1", "old task", "old newdesc", "4", "2", "1111","new name","new desc","4","8"});

        new StartUI(inputEdit).init();

        /**
         * Добавление комментария
         */
        Input inputComm = new StubInput(new String[]{"1", "old task", "old newdesc", "4","3","1111","new comment","4","8"});

        new StartUI(inputComm).init();

        /**
         * Поиск по id
         */
        Input inputId = new StubInput(new String[]{"1", "old task", "old newdesc", "4","6","1111", "8"});

        new StartUI(inputId).init();

        /**
         * Поиск слов в заявке
         */
        Input inputWord = new StubInput(new String[]{"1", "old task", "old newdesc", "4","5","test","8"});

        new StartUI(inputWord).init();

        /**
         *  Удаление заявки
         */
        Input inputDelete = new StubInput(new String[]{"1", "old task", "old newdesc", "4","7","1111","4","8"});

        new StartUI(inputDelete).init();




    }

}