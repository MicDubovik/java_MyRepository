package ru.job4j.Iterator.IteratorMy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IteratorForArrayTest {

    @Test
    public void checkMyIteratorNext(){

        int[][] values = new int[][]{
                {1, 2},
                {3, 4}};
        IteratorForArray itfa = new IteratorForArray(values);

        itfa.next();
        itfa.next();
        int result = (Integer) itfa.next();

        assertThat(result,is(3));
    }

    @Test
    public void checkMyIteratorBool(){
        int[][] values = new int[][]{
                {1, 2},
                {3, 4}};
        IteratorForArray itfa = new IteratorForArray(values);

        itfa.next();
        itfa.next();
        itfa.next();
        itfa.hasNext();
        itfa.next();

        boolean result = itfa.hasNext();

        assertThat(result,is(false));

    }
}