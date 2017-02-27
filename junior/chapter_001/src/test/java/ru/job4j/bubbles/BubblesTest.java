package ru.job4j.bubbles;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Katy on 23.02.2017.
 */
public class BubblesTest {
    @Test
    public void methodBubles() {

        Bubbles bubbles = new Bubbles();
        int[] array = new int[]{2,1,6,3};
        int[]  resultArray = bubbles.methodBubles(array);
        int[] expectArray =new int[]{1,2,3,6};
        assertThat(resultArray, is(expectArray));
    }

}