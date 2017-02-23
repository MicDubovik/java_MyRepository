package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Turn.
 */
public class TurnTest {
    /**
     * Тестируем метод back().
     */
    @Test
    public void back() {
        Turn turn = new Turn();

        int[] array = new int[]{1,2,3};
      int[]  resultArray = turn.back(array);
      int[] expectArray =new int[]{3,2,1};
        assertThat(resultArray, is(expectArray));
    }

}