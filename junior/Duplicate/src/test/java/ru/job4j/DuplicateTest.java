package ru.job4j;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Duplicate
 */
public class DuplicateTest {

    /**
     * Тестируем метод удаления дубликатов.
     */
    @Test
    public void removeDuplicate()  {

        Duplicate duplicate = new Duplicate();
        String[] strings = {"Привет", "Привет", "Мир", "Мир","Паровоз","Мир"};
        String[]  resultArray = duplicate.removeDuplicate(strings);
        String[] expectArray =new String[]{"Привет","Мир","Паровоз" };
        assertThat(resultArray, is(expectArray));



    }

}