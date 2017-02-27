package ru.job4j.turnArray;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Turnarray.
 */
public class TurnArrayTest {
    /**
     * Тестируем метод methodTurn().
     */

    @Test
    public void methodTurn() {
        TurnArray turnarray = new TurnArray();

        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][]  resultArray = turnarray.methodTurn(array);
        int[][] expectArray =new int[][]{{3,6,9},{2,5,8},{1,4,7}};
        assertThat(resultArray, is(expectArray));

    }

}